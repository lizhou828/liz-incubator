package com.liz.genCode.plugins;


import com.liz.common.pojo.Pagination;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;


/**
 * Created by lizhou on 2016/7/26
 * 以拦截器的方式实现sql分页查询(MYSQL)
 */

@Intercepts({    @Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
)})
public class PaginationPluginInterceptor implements Interceptor {

    private Log logger = LogFactory.getLog(this.getClass());

    public PaginationPluginInterceptor() {
    }

    public Object intercept(Invocation invocation) throws Throwable {
        Object parameterObject = invocation.getArgs()[1];
        Pagination page = null;
        if(parameterObject != null && parameterObject instanceof Pagination) {
            page = (Pagination)parameterObject;
        } else if(parameterObject != null && parameterObject instanceof Map) {
            Iterator params = ((Map)parameterObject).entrySet().iterator();

            while(params.hasNext()) {
                Map.Entry i$ = (Map.Entry)params.next();
                if(i$.getValue() instanceof Pagination) {
                    page = (Pagination)i$.getValue();
                    break;
                }
            }
        }

        if(page != null) {
            if(page.isPaginationFlag()) {
                return this.pageIntercept(invocation);
            }

            Object params1 = null;
            Iterator i$1 = ((Map)parameterObject).entrySet().iterator();

            while(i$1.hasNext()) {
                Map.Entry e = (Map.Entry)i$1.next();
                if(!(e.getValue() instanceof Pagination)) {
                    params1 = e.getValue();
                    break;
                }
            }

            invocation.getArgs()[1] = params1;
        }

        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
    }

    private Object pageIntercept(Invocation invocation) throws Throwable {
        boolean rowCount = false;
        MappedStatement mappedStatement = (MappedStatement)invocation.getArgs()[0];
        Object parameterObject = invocation.getArgs()[1];
        Pagination page = null;
        if(parameterObject instanceof Pagination) {
            page = (Pagination)parameterObject;
        } else if(parameterObject instanceof Map) {
            Iterator sqlSource = ((Map)parameterObject).entrySet().iterator();

            while(sqlSource.hasNext()) {
                Map.Entry newMappedStatement = (Map.Entry)sqlSource.next();
                if(newMappedStatement.getValue() instanceof Pagination) {
                    page = (Pagination)newMappedStatement.getValue();
                } else {
                    parameterObject = newMappedStatement.getValue();
                }
            }
        }

        SqlSource sqlSource1 = this.getCountSqlSource(mappedStatement, parameterObject);
        MappedStatement newMappedStatement1 = this.copyMappedStatementBySqlSource(mappedStatement, sqlSource1);

        int rowCount1;
        try {
            Cache e = newMappedStatement1.getCache();
            if(newMappedStatement1.isUseCache() && e != null) {
                Executor exe = (Executor)invocation.getTarget();
                CacheKey cacheKey = exe.createCacheKey(newMappedStatement1, parameterObject, (RowBounds)invocation.getArgs()[2], sqlSource1.getBoundSql(parameterObject));
                Object cacheResult = e.getObject(cacheKey);
                if(cacheResult != null) {
                    rowCount1 = ((Integer)cacheResult).intValue();
                } else {
                    rowCount1 = this.queryRowCountFromDB(mappedStatement, newMappedStatement1, parameterObject, sqlSource1).intValue();
                    e.putObject(cacheKey, Integer.valueOf(rowCount1));
                }
            } else {
                rowCount1 = this.queryRowCountFromDB(mappedStatement, newMappedStatement1, parameterObject, sqlSource1).intValue();
            }

            this.logger.debug("total = " + rowCount1);
        } catch (Exception var12) {
            this.logger.error(var12, var12);
            throw var12;
        }

        if(page == null) {
            page = new Pagination();
        }

        page.setTotal(rowCount1);
        sqlSource1 = this.getPageLimitSqlSource(mappedStatement, parameterObject, page);
        newMappedStatement1 = this.copyMappedStatementBySqlSource(mappedStatement, sqlSource1);
        invocation.getArgs()[0] = newMappedStatement1;
        invocation.getArgs()[1] = parameterObject;
        return invocation.proceed();
    }

    private Integer queryRowCountFromDB(MappedStatement mappedStatement, MappedStatement newMappedStatement, Object parameterObject, SqlSource sqlSource) throws Throwable {
        Integer rowCount = null;
        ResultSet rs = null;
        PreparedStatement countStmt = null;

        try {
            DefaultSqlSessionFactory e = new DefaultSqlSessionFactory(mappedStatement.getConfiguration());
            DefaultParameterHandler dp = new DefaultParameterHandler(mappedStatement, parameterObject, sqlSource.getBoundSql(parameterObject));
            String sql = sqlSource.getBoundSql(parameterObject).getSql();
            countStmt = e.openSession().getConnection().prepareStatement(sql);
            dp.setParameters(countStmt);
            rs = countStmt.executeQuery();
            if(rs.next()) {
                rowCount = Integer.valueOf(rs.getInt(1));
            }

            this.logger.debug("sql = " + sql);
        } catch (Exception var14) {
            this.logger.error(var14, var14);
            throw var14;
        } finally {
            if(rs != null) {
                rs.close();
            }

            if(countStmt != null) {
                countStmt.close();
            }

        }

        return rowCount;
    }

    private DynamicContext getDynamicContext(MappedStatement mappedStatement, Object parameterObject) throws Throwable {
        SqlSource nowSqlSource = mappedStatement.getSqlSource();
        Class sqlSourceType = nowSqlSource == null?Object.class:nowSqlSource.getClass();
        Field rootSqlNodeField = sqlSourceType.getDeclaredField("rootSqlNode");
        rootSqlNodeField.setAccessible(true);
        SqlNode sqlNode = (SqlNode)rootSqlNodeField.get(nowSqlSource);
        DynamicContext context = new DynamicContext(mappedStatement.getConfiguration(), parameterObject);
        sqlNode.apply(context);
        return context;
    }

    private SqlSource getCountSqlSource(MappedStatement mappedStatement, Object parameterObject) throws Throwable {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(mappedStatement.getConfiguration());
        DynamicContext context = this.getDynamicContext(mappedStatement, parameterObject);
        Class parameterType = parameterObject == null?Object.class:parameterObject.getClass();
        String newSql = "select count(1) from ( " + context.getSql() + " ) t";
        SqlSource sqlSource = sqlSourceParser.parse(newSql, parameterType, context.getBindings());
        return sqlSource;
    }

    private SqlSource getPageLimitSqlSource(MappedStatement mappedStatement, Object parameterObject, Pagination pagination) throws Throwable {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(mappedStatement.getConfiguration());
        DynamicContext context = this.getDynamicContext(mappedStatement, parameterObject);
        Class parameterType = parameterObject == null?Object.class:parameterObject.getClass();
        int start = (pagination.getPageNo() - 1) * pagination.getPageSize();
        int end = pagination.getPageNo() * pagination.getPageSize();
        String newSql = this.getLimitString(context.getSql(), start, end);
        SqlSource sqlSource = sqlSourceParser.parse(newSql, parameterType, context.getBindings());
        return sqlSource;
    }

    private MappedStatement copyMappedStatementBySqlSource(MappedStatement mappedStatement, SqlSource sqlSource) {
        Builder builder = new Builder(mappedStatement.getConfiguration(), mappedStatement.getId(), sqlSource, mappedStatement.getSqlCommandType());
        builder.resource(mappedStatement.getResource());
        builder.fetchSize(mappedStatement.getFetchSize());
        builder.statementType(mappedStatement.getStatementType());
        builder.keyGenerator(mappedStatement.getKeyGenerator());
        builder.timeout(mappedStatement.getTimeout());
        builder.parameterMap(mappedStatement.getParameterMap());
        builder.resultMaps(mappedStatement.getResultMaps());
        builder.resultSetType(mappedStatement.getResultSetType());
        builder.cache(mappedStatement.getCache());
        builder.flushCacheRequired(mappedStatement.isFlushCacheRequired());
        builder.useCache(mappedStatement.isUseCache());
        MappedStatement newMappedStatement = builder.build();
        return newMappedStatement;
    }

    private String getLimitString(String sql, int offset, int limit) {
        StringBuilder finalSql = new StringBuilder();
        finalSql.append(sql).append(" limit ").append(offset).append(",").append(limit - offset);
        return finalSql.toString();
    }

}
