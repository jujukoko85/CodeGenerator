
/**
* ${entity.comment}
* @author zhuzhaohua
/*
<#assign interfaceStr = "" />
<#if entity.interfaces??>
    <#assign interfaceStr = "implements " />
    <#list entity.interfaces as interface>
        <#assign interfaceStr += interface.interfaceName()>
        <#if (interface_index + 1) lt entity.interfaces?size>
            <#assign interfaceStr += ', '>
        </#if>
    </#list>
</#if>
public class ${entity.className()} ${interfaceStr} {

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

    public ${entity.className()} set${property.camelBigName()}(${property.typeName()} ${property.camelBigName()}) {
        this.${property.camelSmallName()} = ${property.camelSmallName()};
        return this;
    }
        </#list>
    </#if>
}