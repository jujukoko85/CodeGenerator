<#assign entityType = entity.camelBigName() />
<#assign primaryType = entity.primary().typeName() />

<#--FIXME 导包问题-->
import com.howard.plat.base.utils.PageBean;
import com.howard.plat.base.utils.PageParam;

public interface ${entityType}Repository {

    void save(${entityType} entity);

    ${entityType} getById(${entityType} id);

    int update(${entityType} entity);

    int delete(${entityType} id);

    PageBean<${entityType}> getPage(PageParam pageParam, ${entityType} example);

}
// blank line