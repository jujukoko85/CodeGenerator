package top.howard85.code.generator.entity;

import java.util.List;

public class EntityClazz {

    private Class parent;

    private List<EntityInterface> interfaces;

    private String name;

    private String comment;

    private List<EntityProperty> properties;

    public String className() {
        if (1 == name.length()) {
            return name.toUpperCase();
        } else {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
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

    public Class getParent() {
        return parent;
    }

    public EntityClazz setParent(Class parent) {
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
