package top.howard85.code.generator.generation;

import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import top.howard85.code.generator.entity.EntityClazz;
import top.howard85.code.generator.entity.EntityInterface;
import top.howard85.code.generator.entity.EntityProperty;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GeneratorFreemarkerTest {

    @Test
    public void test1() throws IOException, TemplateException {
        GeneratorFreemarker g = new GeneratorFreemarker();
        Map<String, Object> map = new HashMap<>();
        map.put("entity", buildEntity());
//        String content = g.merge(map, "entity_rich.ftl");
//        String content = g.merge(map, "entity.ftl");
//        String content = g.merge(map, "repository.ftl");
//        String content = g.merge(map, "repository_mapper.ftl");
//        String content = g.merge(map, "repository_mybatis_plus.ftl");
//        String content = g.merge(map, "dto.ftl");
//        String content = g.merge(map, "assembler.ftl");
//        String content = g.merge(map, "service.ftl");
//        String content = g.merge(map, "service_impl.ftl");
//        String content = g.merge(map, "controller.ftl");
//        String content = g.merge(map, "vo.ftl");
//        String content = g.merge(map, "page_list.ftl");
        String content = g.merge(map, "page_edit.ftl");
        assertNotNull(content);
        System.out.println(content);
    }

    private EntityClazz buildEntity() {
        EntityClazz clazz = new EntityClazz("student", "这是个注释");

        List<EntityInterface> interfaces = new ArrayList<>();
        interfaces.add(new EntityInterface(Serializable.class));
        clazz.setInterfaces(interfaces);

//        clazz.setParent(new EntityParent(Man.class));

        List<EntityProperty> properties = new ArrayList<>();
        properties.add(new EntityProperty(Long.class, "id", "主键").setPrimary(true));
        properties.add(new EntityProperty(Integer.class, "age", "年龄"));
//        properties.add(new EntityProperty(Person.class, "persons", ""));

        clazz.setProperties(properties);
        return clazz;
    }


}

