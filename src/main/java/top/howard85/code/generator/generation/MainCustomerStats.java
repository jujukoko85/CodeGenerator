package top.howard85.code.generator.generation;

import freemarker.template.TemplateException;
import top.howard85.code.generator.entity.EntityClazz;
import top.howard85.code.generator.entity.EntityInterface;
import top.howard85.code.generator.entity.EntityProperty;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class MainCustomerStats {

    public static void main(String[] args) throws IOException, TemplateException {
        Project project = new Project("D:/paper");
//        project.setController(EntityPkg.create("com.howard.plat.controller.paper"));
//        project.setService(EntityPkg.create("com.howard.plat.base.service"));
//        project.setServiceImpl(EntityPkg.create("com.howard.plat.paper.impl"));
//        project.setRepository(EntityPkg.create("com.howard.plat.paper.repository"));
//        project.setRepositoryMybatisPlus(EntityPkg.create("com.howard.plat.paper.repository.mybatis"));
//        project.setModel(EntityPkg.create("com.howard.plat.paper.model"));
//        project.setMapper(EntityPkg.create("com.howard.plat.paper.repository.mybatis"));

        EntityClazz entity = new EntityClazz("statsCustomerBizMonth", "客户月(业务月)统计信");
        entity.addInterface(new EntityInterface("com.howard.plat.base.model.Entity"));
        entity
                .addProperty(new EntityProperty(Long.class,         "id",                   "id").setPrimary(true))
                .addProperty(new EntityProperty(Long.class,         "customerId",           "客户ID"))
                .addProperty(new EntityProperty(Integer.class,      "orderBizMonth",        "核算月份 202109"))
                .addProperty(new EntityProperty(BigDecimal.class,   "orderSquare",          "月订单总平方 平米"))
                .addProperty(new EntityProperty(Integer.class,      "orderSquareTarget",    "月订单总平方目标  平米"))
                .addProperty(new EntityProperty(BigDecimal.class,   "orderSquareDiff",      "月订单总平方差额  平米"))
                .addProperty(new EntityProperty(BigDecimal.class,   "gpSaler",              "月销售员毛利合计"))
                .addProperty(new EntityProperty(BigDecimal.class,   "amtLoss",              "月客诉赔偿金额"))
                .addProperty(new EntityProperty(Integer.class,      "complainCount",        "月客诉次数"))
                .addProperty(new EntityProperty(BigDecimal.class,   "amt",                  "月订单金额"))
                .addProperty(new EntityProperty(Integer.class,      "orderDayCount",        "月下单频次(1天下多单算1次)"))
                .addProperty(new EntityProperty(Integer.class,      "materialCount",        "月下次材质数量"))
                .addProperty(new EntityProperty(BigDecimal.class,   "orderMetersAvg",       "月订单米数平均数 米"))
                .addProperty(new EntityProperty(BigDecimal.class,   "orderMetersMedian",    "月订单米数中位数 米"))
                .addProperty(new EntityProperty(Date.class,         "crtTs",                "创建时间"))
                .addProperty(new EntityProperty(String.class,       "crtUser",              "创建人"));
        project.addEntity(entity);

        project.generate();

    }
}
