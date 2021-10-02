package top.howard85.code.generator.entity;

public class EntityTemplate {

    private short type = 1; // 1: java 2: ftl

    private String templateFileName;

    private String targetFileSuffix;

    private EntityClazz entity;

    public EntityTemplate(String templateFileName, String targetFileSuffix, short type) {
        this.templateFileName = templateFileName;
        this.targetFileSuffix = targetFileSuffix;
        this.type = type;
    }

    public String getFileName() {
        return String.format("%s%s%s", 1 ==  type ? entity.camelBigName() : entity.lineName(), targetFileSuffix, 1 == type ? ".java" : ".ftl");
    }

    public String getTemplateFileName() {
        return templateFileName;
    }

    public EntityTemplate setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
        return this;
    }

    public EntityClazz getEntity() {
        return entity;
    }

    public EntityTemplate setEntity(EntityClazz entity) {
        this.entity = entity;
        return this;
    }

    public String getTargetFileSuffix() {
        return targetFileSuffix;
    }

    public EntityTemplate setTargetFileSuffix(String targetFileSuffix) {
        this.targetFileSuffix = targetFileSuffix;
        return this;
    }

    public short getType() {
        return type;
    }

    public EntityTemplate setType(short type) {
        this.type = type;
        return this;
    }
}
