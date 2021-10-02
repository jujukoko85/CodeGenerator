package top.howard85.code.generator.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityPkgTest {

    @Test
    public void test1() {
        EntityPkg pkg = EntityPkg.create("com.howard.plat.service.impl");
        String fullName = pkg.fullName();
        assertNotNull(fullName);
        System.out.println(fullName);
    }
}
