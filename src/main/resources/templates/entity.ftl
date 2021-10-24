<#--FIXME 导包问题-->
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

<#-- 集成父类的导包 -->
<#if entity.parent??>
import ${entity.parent.typeFullName()};
</#if>
<#-- 实现接口的导包 -->
<#if entity.interfaces??>
    <#list entity.interfaces as interface>
import ${interface.typeFullName()};
    </#list>
</#if>
<#-- 属性依赖的导包 -->
<#if entity.properties??>
    <#list entity.properties as property>
import ${property.typeFullName()};
    </#list>
</#if>
<#-- 拼接父类符串 extends ArrayList -->
<#assign parentStr = "" />
<#if entity.parent??>
    <#assign parentStr = "extends " + entity.parent.typeName() />
</#if>
<#-- 拼接接口字符串 implements List -->
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
<#assign entityType = entity.camelBigName() />
/**
* ${entity.comment}
* @author zhuzhaohua
*/
public class ${entityType} ${parentStr} ${interfaceStr} {

    <#if entity.properties??>
        <#list entity.properties as property>
    // ${property.comment}
            <#if property.isPrimary()>
    @TableId(type = IdType.AUTO)
            </#if>
    private ${property.typeName()} ${property.camelSmallName()};
        </#list>
    </#if>

    <#if entity.properties??>
        <#list entity.properties as property>
    public ${property.typeName()} get${property.camelBigName()}() {
        return this.${property.camelSmallName()};
    }

    public ${entityType} set${property.camelBigName()}(${property.typeName()} ${property.camelSmallName()}) {
        this.${property.camelSmallName()} = ${property.camelSmallName()};
        return this;
    }
        </#list>
    </#if>
}
// blank line
