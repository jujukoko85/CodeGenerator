package top.howard85.code.generator.generation;

import freemarker.template.TemplateException;
import top.howard85.code.generator.entity.EntityClazz;
import top.howard85.code.generator.entity.EntityInterface;
import top.howard85.code.generator.entity.EntityProperty;

import java.io.IOException;
import java.util.Date;

public class MainArea {

    public static void main(String[] args) throws IOException, TemplateException {
        Project project = new Project("D:/paper");
//        project.setController(EntityPkg.create("com.howard.plat.controller.paper"));
//        project.setService(EntityPkg.create("com.howard.plat.base.service"));
//        project.setServiceImpl(EntityPkg.create("com.howard.plat.paper.impl"));
//        project.setRepository(EntityPkg.create("com.howard.plat.paper.repository"));
//        project.setRepositoryMybatisPlus(EntityPkg.create("com.howard.plat.paper.repository.mybatis"));
//        project.setModel(EntityPkg.create("com.howard.plat.paper.model"));
//        project.setMapper(EntityPkg.create("com.howard.plat.paper.repository.mybatis"));

        EntityClazz entity = new EntityClazz("customerArea", "客户区域");
        entity.addInterface(new EntityInterface("com.howard.plat.base.model.Entity"));
        entity
                .addProperty(new EntityProperty(Long.class, "id", "id").setPrimary(true))
                .addProperty(new EntityProperty(String.class, "areaName", "区域名称"))
                .addProperty(new EntityProperty(String.class, "remark", "备注"))
                .addProperty(new EntityProperty(Date.class, "updTs", "更新时间"))
                .addProperty(new EntityProperty(String.class, "updUser", "更新人"))
                .addProperty(new EntityProperty(Date.class, "crtTs", "创建时间"))
                .addProperty(new EntityProperty(String.class, "crtUser", "创建人"));
        project.addEntity(entity);

        project.generate();

    }
}
