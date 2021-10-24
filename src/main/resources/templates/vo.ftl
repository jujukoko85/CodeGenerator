<#assign voType = entity.camelBigName() + "Vo" />
<#assign dtoType = entity.camelBigName() + "Dto" />
import static com.howard.plat.controller.base.BaseController.DEFAULT_CURR_PAGE;
import static com.howard.plat.controller.base.BaseController.DEFAULT_PAGE_SIZE;
import com.howard.plat.base.utils.NumberUtil;
import com.howard.plat.base.utils.DateUtil;

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
<#if entity.properties??>
    <#list entity.properties as property>
        <#switch property.getClazzEnumCode()>
            <#case 1> <#-- String -->
        dto.set${property.camelBigName()}(this.${property.camelSmallName()});<#break>
            <#case 2> <#-- Short -->
        dto.set${property.camelBigName()}(NumberUtil.parseShortIfValid(this.${property.camelSmallName()}));<#break>
            <#case 3> <#-- Integer -->
        dto.set${property.camelBigName()}(NumberUtil.parseIntegerIfValid(this.${property.camelSmallName()}));<#break>
            <#case 4> <#-- Long -->
        dto.set${property.camelBigName()}(NumberUtil.parseLongIfValid(this.${property.camelSmallName()}));<#break>
            <#case 5> <#-- Double -->
        dto.set${property.camelBigName()}(NumberUtil.parseDoubleIfValid(this.${property.camelSmallName()}));<#break>
            <#case 6> <#-- BigDecimal -->
        dto.set${property.camelBigName()}(NumberUtil.parseBigDecimalIfValid(this.${property.camelSmallName()}));<#break>
            <#case 7> <#-- BigDecimal -->
        dto.set${property.camelBigName()}(NumberUtil.parseBigDecimalIfValid(this.${property.camelSmallName()}));<#break>
            <#case 8> <#-- Date -->
        dto.set${property.camelBigName()}(DateUtil.parseDatetime(this.${property.camelSmallName()}));<#break>
            <#case 9> <#-- LocalDat -->
        dto.set${property.camelBigName()}(DateUtil.parseLocalDate(this.${property.camelSmallName()}));<#break>
            <#case 10> <#-- LocalDateTime -->
        dto.set${property.camelBigName()}(DateUtil.parseLocalDateTime(this.${property.camelSmallName()}));<#break>
            <#default>
        </#switch>
    </#list>
</#if>

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
