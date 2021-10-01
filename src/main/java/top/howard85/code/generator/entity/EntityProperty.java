package top.howard85.code.generator.entity;

public class EntityProperty {

    private Class clazz; //

    private boolean isRawType = false; // 是否是原生类型

    private String name;

    private String comment;

    public EntityProperty() {
    }

    public EntityProperty(Class clazz, String name, String comment) {
        this.clazz = clazz;
        this.name = name;
        this.comment = comment;
    }

    public EntityProperty(Class clazz, boolean isRawType, String name, String comment) {
        this.clazz = clazz;
        this.isRawType = isRawType;
        this.name = name;
        this.comment = comment;
    }

    public String camelSmallName() {
        if (1 == name.length()) {
            return name.toLowerCase();
        }
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }

    public String camelBigName() {
        if (1 == name.length()) {
            return name.toUpperCase();
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public String typeFullName() {
        if (isRawType) {
            // FIXME
            return clazz.getName();
        } else {
            return clazz.getName();
        }
    }

    public String typeName() {
        if (isRawType) {
            // FIXME
            return clazz.getSimpleName();
        } else {
            return clazz.getSimpleName();
        }
    }

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
