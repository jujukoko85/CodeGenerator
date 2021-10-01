<#assign dtoType = entity.camelBigName() + "Dto" />
<#--FIXME 导包问题-->
import com.howard.plat.base.model.Dto;

public class ${dtoType} implements Dto {

<#if entity.properties??>
    <#list entity.properties as property>
    // ${property.comment}
    private ${property.typeName()} ${property.camelSmallName()};
    </#list>
</#if>

<#if entity.properties??>
    <#list entity.properties as property>
    public ${property.typeName()} get${property.camelBigName()}() {
        return this.${property.camelSmallName()};
    }

    public ${dtoType} set${property.camelBigName()}(${property.typeName()} ${property.camelSmallName()}) {
        this.${property.camelSmallName()} = ${property.camelSmallName()};
        return this;
    }
    </#list>
</#if>

}
// blank line