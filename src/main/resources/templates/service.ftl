<#assign dtoType = entity.camelBigName() + "Dto" />
<#assign entityType = entity.camelBigName() />
<#assign primaryType = entity.primary().typeName() />
<#--FIXME 导包问题-->
import com.howard.plat.base.utils.PageBean;
import com.howard.plat.base.utils.PageParam;

public interface ${entityType}Service {

    PageBean<${dtoType}> getPage(PageParam pageParam, ${dtoType} example);

    ${dtoType} getById(${primaryType} id);

    void doCreate(${dtoType} example, String currentUser);

    void update(${primaryType} id, ${dtoType} example, String currentUser);

    void delete(${primaryType} id, String currentUser);
}
// blank line
