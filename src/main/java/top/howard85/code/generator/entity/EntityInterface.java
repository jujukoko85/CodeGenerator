package top.howard85.code.generator.entity;

public class EntityInterface {

    private Class clazz;

    public EntityInterface(Class clazz) {
        this.clazz = clazz;
    }

    public String typeName() {
        return clazz.getSimpleName();
    }

    public String typeFullName() {
        return clazz.getName();
    }

    public Class getClazz() {
        return clazz;
    }

    public EntityInterface setClazz(Class clazz) {
        this.clazz = clazz;
        return this;
    }
}
