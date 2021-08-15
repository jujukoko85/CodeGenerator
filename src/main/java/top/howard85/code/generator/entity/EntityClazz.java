package top.howard85.code.generator.entity;

import java.util.List;

public class EntityClazz {

    private EntityPkg pkg; //

    private String comment;

    private List<EntityProperty> properties;

    public String getComment() {
        return comment;
    }

    public EntityClazz setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public EntityPkg getPkg() {
        return pkg;
    }

    public EntityClazz setPkg(EntityPkg pkg) {
        this.pkg = pkg;
        return this;
    }

    public List<EntityProperty> getProperties() {
        return properties;
    }

    public EntityClazz setProperties(List<EntityProperty> properties) {
        this.properties = properties;
        return this;
    }
}
