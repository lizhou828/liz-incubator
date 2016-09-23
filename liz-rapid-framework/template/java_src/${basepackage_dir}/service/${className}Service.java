<#include "/java_copyright.include">
<#assign className=table.className>
<#assign classNameLower=className?uncap_first>

package ${basepackage}.service;

import ${basepackage}.model.${className};
import com.liz.common.pojo.Pagination;
import java.util.List;

public interface ${className}Service{

    /**
     * 通过主键查询实体对象
     *
     * @param primaryKey
     * @return
     * @throws Exception
     */
    public ${className} getByPK(java.lang.Integer primaryKey) throws Exception;

    /**
     * 查询所有记录
     * @return
     * @throws Exception
     */
    public List<${className}> list() throws Exception;

    /**
     * 根据查询条件查询所有记录
     * @return
     * @throws Exception
     */
    public List<${className}> listByProperty(${className} ${classNameLower}) throws Exception;


    /**
     * 根据主键删除记录
     * @param primaryKey
     * @return
     * @throws Exception
     */
    public int deleteByPK(java.lang.Integer primaryKey) throws Exception;

    /**
     * 根据多个主键删除记录
     * @param primaryKeys
     * @throws Exception
     */
    public void deleteByPKeys(List<java.lang.Integer>primaryKeys) throws Exception;

    /**
     * 根据传入参数删除记录
     * @param ${classNameLower}
     * @return
     * @throws Exception
     */
    public int deleteByProperty(${className} ${classNameLower}) throws Exception;

    /**
     * 保存记录
     * @param ${classNameLower}
     * @return
     * @throws Exception
     */
    public void save(${className} ${classNameLower}) throws Exception;

    /**
     * 更新记录
     * @param ${classNameLower}
     * @return
     * @throws Exception
     */
    public int update(${className} ${classNameLower}) throws Exception;

    /**
     * 根据条件查询记录条数
     * @param ${classNameLower}
     * @return
     * @throws Exception
     */
    public int findByCount (${className} ${classNameLower}) throws Exception;

    /**
     * 根据查询条件查询分页记录
     * @return
     * @throws Exception
     */
    public Pagination<${className}> findByPagination(Pagination<${className}> pagination,${className} ${classNameLower}) throws Exception;

}
