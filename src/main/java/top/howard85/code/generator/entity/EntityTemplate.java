package top.howard85.code.generator.entity;

public class EntityTemplate {

    private String templateFileName;

    private String targetFileSuffix;

    private EntityClazz entity;

    public EntityTemplate(String templateFileName, String targetFileSuffix) {
        this.templateFileName = templateFileName;
        this.targetFileSuffix = targetFileSuffix;
    }

    public String getFileName() {
        return String.format("%s%s", entity.camelBigName(), targetFileSuffix);
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
}
