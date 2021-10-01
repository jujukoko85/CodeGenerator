<#if entity.parent??>
import ${entity.parent.typeFullName()};
</#if>

<#if entity.interfaces??>
    <#list entity.interfaces as interface>
import ${interface.typeFullName()};
    </#list>
</#if>

<#if entity.properties??>
    <#list entity.properties as property>
import ${property.typeFullName()};
    </#list>
</#if>

<#assign parentStr = "" />
<#if entity.parent??>
    <#assign parentStr = "extends " + entity.parent.typeName() />
</#if>

<#assign interfaceStr = "" />
<#if entity.interfaces??>
    <#assign interfaceStr = "implements " />
    <#list entity.interfaces as interface>
        <#assign interfaceStr += interface.typeName()>
        <#if (interface_index + 1) lt entity.interfaces?size>
            <#assign interfaceStr += ', '>
        </#if>
    </#list>
</#if>

/**
* ${entity.comment}
* @author zhuzhaohua
*/
public class ${entity.className()} ${parentStr} ${interfaceStr} {

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

    public ${entity.className()} set${property.camelBigName()}(${property.typeName()} ${property.camelSmallName()}) {
        this.${property.camelSmallName()} = ${property.camelSmallName()};
        return this;
    }
        </#list>
    </#if>
}
// blank line