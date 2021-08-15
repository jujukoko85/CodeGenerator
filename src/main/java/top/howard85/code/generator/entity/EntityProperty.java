package top.howard85.code.generator.entity;

public class EntityProperty {

    private Class clazz; //

    private boolean isRawType = false; // 是否是原生类型

    private String name;

    private String comment;

    public String getComment() {
        return comment;
    }

    public EntityProperty setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Class getClazz() {
        return clazz;
    }

    public EntityProperty setClazz(Class clazz) {
        this.clazz = clazz;
        return this;
    }

    public boolean isRawType() {
        return isRawType;
    }

    public EntityProperty setRawType(boolean rawType) {
        isRawType = rawType;
        return this;
    }

    public String getName() {
        return name;
    }

    public EntityProperty setName(String name) {
        this.name = name;
        return this;
    }
}
