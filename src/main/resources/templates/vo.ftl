<#assign voType = entity.camelBigName() + "Vo" />
<#assign dtoType = entity.camelBigName() + "Dto" />
import static com.howard.plat.controller.base.BaseController.DEFAULT_CURR_PAGE;
import static com.howard.plat.controller.base.BaseController.DEFAULT_PAGE_SIZE;

public class ${voType} {

    private Integer currentPage = DEFAULT_CURR_PAGE;
    private Integer pageSize = DEFAULT_PAGE_SIZE;

<#if entity.properties??>
    <#list entity.properties as property>
    // ${property.comment}
    private String ${property.camelSmallName()};
    </#list>
</#if>

    public ${dtoType} toDto() {
        ${dtoType} dto = new ${dtoType}();
        // FIXME 完成类型转换
        return dto;
    }

<#if entity.properties??>
    <#list entity.properties as property>
    public String get${property.camelBigName()}() {
        return this.${property.camelSmallName()};
    }

    public ${voType} set${property.camelBigName()}(String ${property.camelSmallName()}) {
        this.${property.camelSmallName()} = ${property.camelSmallName()};
        return this;
    }
    </#list>
</#if>

    public Integer getCurrentPage() {
        return currentPage;
    }

    public ${voType} setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public ${voType} setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
// blank line
