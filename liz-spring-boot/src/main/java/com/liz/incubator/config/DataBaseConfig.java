package com.liz.incubator.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.liz.incubator.Interceptor.PaginationInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by lizhou on 2015/12/11
 *
 * Spring boot 集成 Mybatis 的配置文件
 * @author  lizhou
 * @since   2015-12-11
 * @version 1.0
 */

@Configuration
@EnableTransactionManagement
@MapperScan("com.liz.incubator.mapper")
@EnableAutoConfiguration
public class DataBaseConfig {

    @Value("${spring.datasource.driverClassName}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    private final Logger log = LoggerFactory.getLogger(DataBaseConfig.class);

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource() {
        log.debug("Configuring Datasource");
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        try {
            druidDataSource.setFilters("stat, wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    @Bean
    @Primary
    public PlatformTransactionManager txManager() {
        //dataSource() can be any instance of JDBC DataSource ,for example, from jdbc pool or from JNDI
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        /* 配置数据源 */
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        /* 配置持久层 */
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/mapper/*.xml"));

        /* 配置持久层的sql拦截器 */
        Interceptor interceptor = new PaginationInterceptor();
        Interceptor[] interceptors = new Interceptor[]{interceptor};
        sqlSessionFactoryBean.setPlugins(interceptors);
        return sqlSessionFactoryBean.getObject();
    }


}
