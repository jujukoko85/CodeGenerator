package top.howard85.code.generator.generation;

import freemarker.template.TemplateException;
import top.howard85.code.generator.entity.EntityClazz;
import top.howard85.code.generator.entity.EntityInterface;
import top.howard85.code.generator.entity.EntityProperty;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class MainPaperOrder {

    public static void main(String[] args) throws IOException, TemplateException {
        Project project = new Project("D:/paper");
//        project.setController(EntityPkg.create("com.howard.plat.controller.paper"));
//        project.setService(EntityPkg.create("com.howard.plat.base.service"));
//        project.setServiceImpl(EntityPkg.create("com.howard.plat.paper.impl"));
//        project.setRepository(EntityPkg.create("com.howard.plat.paper.repository"));
//        project.setRepositoryMybatisPlus(EntityPkg.create("com.howard.plat.paper.repository.mybatis"));
//        project.setModel(EntityPkg.create("com.howard.plat.paper.model"));
//        project.setMapper(EntityPkg.create("com.howard.plat.paper.repository.mybatis"));

        EntityClazz entity = new EntityClazz("paperOrder", "纸板订单");
        entity.addInterface(new EntityInterface("com.howard.plat.base.model.Entity"));
        entity
                .addProperty(new EntityProperty(Long.class, "id", "id").setPrimary(true))
                .addProperty(new EntityProperty(Long.class, "customerId", "客户ID"))
                .addProperty(new EntityProperty(Long.class, "customerAreaId", "客户区域ID"))
                .addProperty(new EntityProperty(Integer.class, "orderDt", "订单日期"))
                .addProperty(new EntityProperty(String.class, "salerUser", "销售员"))
                .addProperty(new EntityProperty(String.class, "voucherUser", "制单员"))
                .addProperty(new EntityProperty(String.class, "orderNo", "订单单号"))
                .addProperty(new EntityProperty(BigDecimal.class, "up", "单价 元/片"))
                .addProperty(new EntityProperty(BigDecimal.class, "amt", "订单金额"))
                .addProperty(new EntityProperty(BigDecimal.class, "upSquare", "平方单价(订单的平方价) 元/平米"))
                .addProperty(new EntityProperty(BigDecimal.class, "upSquareCom", "公司平方单价(公司规则定平方价) 元/平米 计算保存过后不再更新"))
                .addProperty(new EntityProperty(BigDecimal.class, "upSquareSaler", "销售平方单价(公司规则定平方价) 元/平米 计算保存过后不再更新"))
                .addProperty(new EntityProperty(BigDecimal.class, "gpCom", "公司毛利 元"))
                .addProperty(new EntityProperty(BigDecimal.class, "gpSaler", "销售毛利 元"))
                .addProperty(new EntityProperty(BigDecimal.class, "upSquareAdjust", "平方单价(调整)"))
                .addProperty(new EntityProperty(BigDecimal.class, "gpComAdjust", "公司毛利(调整) 元"))
                .addProperty(new EntityProperty(BigDecimal.class, "gpSalerAdjust", "销售毛利(调整) 元"))
                .addProperty(new EntityProperty(Integer.class, "workLength", "生产长 毫米"))
                .addProperty(new EntityProperty(String.class, "material", "纸质"))
                .addProperty(new EntityProperty(String.class, "boardType", "楞别"))
                .addProperty(new EntityProperty(Integer.class, "orderNum", "订单数"))
                .addProperty(new EntityProperty(BigDecimal.class, "orderSquare", "订单总平方 平米"))
                .addProperty(new EntityProperty(Integer.class, "orderMerters", "单总米数"))
                .addProperty(new EntityProperty(Integer.class, "doorWidth", "门幅 毫米"))
                .addProperty(new EntityProperty(Integer.class, "length", "纸长 毫米"))
                .addProperty(new EntityProperty(Integer.class, "width", "纸宽 毫米"))
                .addProperty(new EntityProperty(Integer.class, "deliverDt", "订单交期"))
                .addProperty(new EntityProperty(Date.class, "orderCrtTs", "订单创建时间"))
                .addProperty(new EntityProperty(Date.class, "orderSchTs", "订单排程时间"))
                .addProperty(new EntityProperty(Date.class, "orderRepoTs", "订单入库时间"))
                .addProperty(new EntityProperty(Date.class, "orderSendTs", "订单发货时间"))
                .addProperty(new EntityProperty(Date.class, "orderFinishTs", "订单回签时间"))
                .addProperty(new EntityProperty(Integer.class, "repoNum", "入库数 片"))
                .addProperty(new EntityProperty(Integer.class, "sendNum", "送货数"))
                .addProperty(new EntityProperty(Date.class, "crtTs", "创建时间"))
                .addProperty(new EntityProperty(String.class, "crtUser", "创建人"))
                .addProperty(new EntityProperty(Date.class, "updTs", "更新时间"))
                .addProperty(new EntityProperty(String.class, "updUser", "更新人"));

        project.addEntity(entity);

        project.generate();

    }
}
