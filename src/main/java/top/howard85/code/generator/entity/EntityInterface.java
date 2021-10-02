package top.howard85.code.generator.entity;

public class EntityInterface {

    private String clazzString;
    private Class clazz;

    public EntityInterface(Class clazz) {
        this.clazz = clazz;
    }

    public EntityInterface(String clazzString) {
        this.clazzString = clazzString;
    }

    public String typeName() {
        if (null != clazzString && 0 != clazzString.length()) {
            return clazzString.substring(clazzString.lastIndexOf('.') + 1);
        }
        return clazz.getSimpleName();
    }

    public String typeFullName() {
        if (null != clazzString && 0 != clazzString.length()) {
            return clazzString;
        }
        return clazz.getName();
    }

    public Class getClazz() {
        if (null != clazzString && 0 != clazzString.length()) {
            try {
                return Class.forName(clazzString);
            } catch (ClassNotFoundException e) {
                return null;
            }
        }
        return clazz;
    }

    public EntityInterface setClazz(Class clazz) {
        this.clazz = clazz;
        this.clazzString = clazz.getName();
        return this;
    }
}
