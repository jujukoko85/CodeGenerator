package top.howard85.code.generator.generation;

import freemarker.template.TemplateException;
import top.howard85.code.generator.entity.EntityClazz;
import top.howard85.code.generator.entity.EntityTemplate;
import top.howard85.code.generator.utils.FilesUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Project {

    private String outputDir;
    private Set<EntityTemplate> templates = new HashSet<>();
    private Generator generator;

    private Set<EntityClazz> entities = new HashSet<>();

    public Project() throws IOException {
        generator =  new GeneratorFreemarker();
        templates.add(new EntityTemplate("assembler.ftl", "Assembler.java"));
        templates.add(new EntityTemplate("controller.ftl", "Controller.java"));
        templates.add(new EntityTemplate("dto.ftl", "Dto.java"));
        templates.add(new EntityTemplate("entity_rich.ftl", ".java"));
        templates.add(new EntityTemplate("page_edit.ftl", "_edit.ftl"));
        templates.add(new EntityTemplate("page_list.ftl", "_list.ftl"));
        templates.add(new EntityTemplate("repository.ftl", "Repository.java"));
        templates.add(new EntityTemplate("repository_mapper.ftl", "Mapper.java"));
        templates.add(new EntityTemplate("repository_mybatis_plus.ftl", "MybatisRepository.java"));
        templates.add(new EntityTemplate("service.ftl", "Service.java"));
        templates.add(new EntityTemplate("service_impl.ftl", "ServiceImpl.java"));
        templates.add(new EntityTemplate("vo.ftl", "Vo.java"));
    }

    public Project(String outputDir) throws IOException {
        this();
        this.outputDir = outputDir;
    }

    public void generate() throws IOException, TemplateException {
        for (EntityClazz entity : entities) {
            for (EntityTemplate template : templates) {
                template.setEntity(entity);
                Map<String, Object> data = new HashMap<>();
                data.put("entity", entity);
                String content = generator.merge(data, template.getTemplateFileName());
                FilesUtils.appendJava(outputDir, template.getFileName(), content);
            }
        }
    }

    public Project addEntity(EntityClazz entity) {
        entities.add(entity);
        return this;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public Project setOutputDir(String outputDir) {
        this.outputDir = outputDir;
        return this;
    }

    public Set<EntityClazz> getEntities() {
        return entities;
    }

    public Project setEntities(Set<EntityClazz> entities) {
        this.entities = entities;
        return this;
    }
}
