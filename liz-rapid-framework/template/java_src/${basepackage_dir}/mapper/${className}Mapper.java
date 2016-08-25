<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.mapper;

import java.util.List;

import ${basepackage}.model.${className};
import ${basepackage}.mapper.GenericIBatisMapper;
import com.liz.common.pojo.Pagination;

public interface ${className}Mapper extends GenericIBatisMapper <${className}, Integer>{

    public List<${className}> findByPagination(Pagination<${className}> pagination, ${className} ${classNameLower});

}