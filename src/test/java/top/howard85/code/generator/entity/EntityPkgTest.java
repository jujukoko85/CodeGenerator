package top.howard85.code.generator.entity;

import org.junit.jupiter.api.Test;

import java.io.File;


class EntityPkgTest {

    @Test
    public void test1() {
        EntityPkg a = new EntityPkg().setName("A");
        EntityPkg b = new EntityPkg().setName("B");
        EntityPkg c = new EntityPkg().setName("C");
        EntityPkg d = new EntityPkg().setName("D");

        a.addChild(b);
        b.addChild(c);
        b.addChild(d);

        File target = new File("D:/");
        c.mkdir(target);
        d.mkdir(target);
    }
}