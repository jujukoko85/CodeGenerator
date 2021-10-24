package top.howard85.code.generator.generation;

import freemarker.template.TemplateException;
import top.howard85.code.generator.entity.EntityClazz;
import top.howard85.code.generator.entity.EntityInterface;
import top.howard85.code.generator.entity.EntityProperty;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class MainCommisionCustomer {

    public static void main(String[] args) throws IOException, TemplateException {
        Project project = new Project("D:/paper");
//        project.setController(EntityPkg.create("com.howard.plat.controller.paper"));
//        project.setService(EntityPkg.create("com.howard.plat.base.service"));
//        project.setServiceImpl(EntityPkg.create("com.howard.plat.paper.impl"));
//        project.setRepository(EntityPkg.create("com.howard.plat.paper.repository"));
//        project.setRepositoryMybatisPlus(EntityPkg.create("com.howard.plat.paper.repository.mybatis"));
//        project.setModel(EntityPkg.create("com.howard.plat.paper.model"));
//        project.setMapper(EntityPkg.create("com.howard.plat.paper.repository.mybatis"));

        EntityClazz entity = new EntityClazz("commisionCustomer", "月度提成表(客户纬度)");
        entity.addInterface(new EntityInterface("com.howard.plat.base.model.Entity"));
        entity
                .addProperty(new EntityProperty(Long.class, "id", "id").setPrimary(true))
                .addProperty(new EntityProperty(Long.class, "customerId", "客户ID"))
                .addProperty(new EntityProperty(Integer.class, "year", "年份 2021"))
                .addProperty(new EntityProperty(Integer.class, "month", "月份 9"))
                .addProperty(new EntityProperty(BigDecimal.class, "amtPreMonth", "上月销售额"))
                .addProperty(new EntityProperty(BigDecimal.class, "amtCurrMonth", "本月销售额"))
                .addProperty(new EntityProperty(LocalDateTime.class, "newTs", "新客时间"))
                .addProperty(new EntityProperty(BigDecimal.class, "paramCommission", "提成系数"))
                .addProperty(new EntityProperty(BigDecimal.class, "paramCustomer", "客户系数"))
                .addProperty(new EntityProperty(String.class, "expressCommission", "提成系数公式"))
                .addProperty(new EntityProperty(String.class, "expressCustomer", "客户系数公式"))
                .addProperty(new EntityProperty(BigDecimal.class, "amtAward", "本月奖金"))
                .addProperty(new EntityProperty(String.class, "saler", "销售"))
                .addProperty(new EntityProperty(String.class, "follower", "跟单"))
                .addProperty(new EntityProperty(String.class, "remark", "备注"))
                .addProperty(new EntityProperty(LocalDateTime.class, "crtTs", "创建时间"))
                .addProperty(new EntityProperty(LocalDateTime.class, "updTs", "更新时间"))
                .addProperty(new EntityProperty(String.class, "crtUser", "创建人"))
                .addProperty(new EntityProperty(String.class, "updUser", "更新人"));

        project.addEntity(entity);

        project.generate();

    }
}
