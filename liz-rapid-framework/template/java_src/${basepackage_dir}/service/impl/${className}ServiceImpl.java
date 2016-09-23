<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

package ${basepackage}.service;

import com.liz.common.pojo.Pagination;
import ${basepackage}.mapper.${className}Mapper;
import ${basepackage}.model.${className};
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
public class ${className}ServiceImpl implements ${className}Service {

    private ${className}Mapper ${classNameLower}Mapper;

    @Autowired
    public void set${className}Mapper(${className}Mapper ${classNameLower}Mapper) {
        this.${classNameLower}Mapper = ${classNameLower}Mapper;
    }

    /**
     * 通过主键查询实体对象
     * @param primaryKey
     * @return
     * @throws Exception
     */
    public ${className} getByPK(java.lang.Integer primaryKey) throws Exception {
        return ${classNameLower}Mapper.getByPK(primaryKey);
    }

    /**
     * 查询所有记录
     * @return
     * @throws Exception
     */
    public List<${className}> list() throws Exception {
        return ${classNameLower}Mapper.list();
    }

    /**
     * 根据查询条件查询所有记录
     * @return
     * @throws Exception
     */
    public List<${className}> listByProperty(${className} ${classNameLower})throws Exception {
        return ${classNameLower}Mapper.listByProperty(${classNameLower});
    }


    /**
     * 根据主键删除记录
     * @param primaryKey
     * @return
     * @throws Exception
     */
    public int deleteByPK(java.lang.Integer primaryKey) throws Exception {
        return ${classNameLower}Mapper.deleteByPK(primaryKey);
    }

    /**
     * 根据多个主键删除记录
     * @param primaryKeys
     * @throws Exception
     */
    public void deleteByPKeys(List<java.lang.Integer> primaryKeys) throws Exception {
        ${classNameLower}Mapper.deleteByPKeys(primaryKeys);
    }

    /**
     * 根据传入参数删除记录
     * @param ${classNameLower}
     * @return
     * @throws Exception
     */
    public int deleteByProperty(${className} ${classNameLower}) throws Exception {
        return ${classNameLower}Mapper.deleteByProperty(${classNameLower});
    }

    /**
     * 保存记录
     * @param ${classNameLower}
     * @return
     * @throws Exception
     */
    public void save(${className} ${classNameLower}) throws Exception {
        ${classNameLower}Mapper.save(${classNameLower});
    }

    /**
     * 更新记录
     * @param ${classNameLower}
     * @return
     * @throws Exception
     */
    public int update(${className} ${classNameLower}) throws Exception{
        return ${classNameLower}Mapper.update(${classNameLower});
    }

    /**
     * 根据条件查询记录条数
     * @param ${classNameLower}
     * @return
     * @throws Exception
     */
    public int findByCount(${className} ${classNameLower}) throws Exception {
        return ${classNameLower}Mapper.findByCount(${classNameLower});
    }

    /**
     * 根据查询条件查询分页记录
     * @return
     * @throws Exception
     */
    public Pagination<${className}> findByPagination(Pagination<${className}> pagination, ${className} ${classNameLower}) throws Exception{
        List<${className}> list = ${classNameLower}Mapper.findByPagination(pagination, ${classNameLower});
        pagination.setResultList(list);
        return pagination;
    }

}
