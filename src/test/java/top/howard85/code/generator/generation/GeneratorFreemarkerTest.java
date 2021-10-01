package top.howard85.code.generator.generation;

import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import top.howard85.code.generator.entity.EntityClazz;
import top.howard85.code.generator.entity.EntityInterface;
import top.howard85.code.generator.entity.EntityParent;
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
        String content = g.merge(map, "entity.ftl");
        assertNotNull(content);
        System.out.println(content);
    }

    private EntityClazz buildEntity() {
        EntityClazz clazz = new EntityClazz();
        clazz.setComment("这个是注释");
        clazz.setName("student");

        List<EntityInterface> interfaces = new ArrayList<>();
        interfaces.add(new EntityInterface(Serializable.class));
        clazz.setInterfaces(interfaces);

        clazz.setParent(new EntityParent(Man.class));

        List<EntityProperty> properties = new ArrayList<>();
        properties.add(new EntityProperty(Integer.class, "age", "年龄"));
        properties.add(new EntityProperty(Person.class, "persons", ""));

        clazz.setProperties(properties);
        return clazz;
    }


}

