package top.howard85.code.generator.entity;

import top.howard85.code.generator.utils.NameUtils;

import java.util.ArrayList;
import java.util.List;

public class EntityClazz {

    private EntityParent parent;

    private List<EntityInterface> interfaces = new ArrayList<>();

    private String name;

    private String comment;

    private List<EntityProperty> properties = new ArrayList<>();

    public EntityClazz(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public EntityClazz addInterface(EntityInterface entityInterface) {
        this.interfaces.add(entityInterface);
        return this;
    }

    public EntityClazz addProperty(EntityProperty property) {
        this.properties.add(property);
        return this;
    }

    public EntityProperty primary() {
        for (EntityProperty property : properties) {
            if (property.isPrimary()) {
                return property;
            }
        }
        return null;
    }

    public String lineName() {
        return NameUtils.humpToLine2(name);
    }

    public String camelBigName() {
        if (1 == name.length()) {
            return name.toUpperCase();
        } else {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
    }

    public String camelSmallName() {
        if (1 == name.length()) {
            return name.toLowerCase();
        } else {
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
    }

    public String getComment() {
        return comment;
    }

    public EntityClazz setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public List<EntityProperty> getProperties() {
        return properties;
    }

    public EntityClazz setProperties(List<EntityProperty> properties) {
        this.properties = properties;
        return this;
    }

    public EntityParent getParent() {
        return parent;
    }

    public EntityClazz setParent(EntityParent parent) {
        this.parent = parent;
        return this;
    }

    public List<EntityInterface> getInterfaces() {
        return interfaces;
    }

    public EntityClazz setInterfaces(List<EntityInterface> interfaces) {
        this.interfaces = interfaces;
        return this;
    }

    public String getName() {
        return name;
    }

    public EntityClazz setName(String name) {
        this.name = name;
        return this;
    }

}
