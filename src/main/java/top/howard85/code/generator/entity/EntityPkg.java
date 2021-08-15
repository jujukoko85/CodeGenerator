package top.howard85.code.generator.entity;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class EntityPkg {

    private String name;

    private EntityPkg parent;

    private List<EntityPkg> children = new LinkedList<>();

    public File mkdir(File targetFile) {
        LinkedList<String> dirTree = new LinkedList<>();
        mkdir(dirTree, this);
        File pkgDir = targetFile;
        for (String dir : dirTree) {
            pkgDir = new File(pkgDir, dir);
            if (pkgDir.exists()) {
                continue;
            }
            pkgDir.mkdirs();
        }
        return pkgDir;
    }

    private EntityPkg mkdir(LinkedList<String> dirTree, EntityPkg pkg) {
        if (null == pkg) {
            return null;
        }
        dirTree.addFirst(pkg.getName());
        return mkdir(dirTree, pkg.getParent());
    }

    public EntityPkg addChild(EntityPkg child) {
        child.setParent(this);
        this.children.add(child);
        return this;
    }

    public String getName() {
        return name;
    }

    public EntityPkg setName(String name) {
        this.name = name;
        return this;
    }

    public EntityPkg getParent() {
        return parent;
    }

    public EntityPkg setParent(EntityPkg parent) {
        this.parent = parent;
        return this;
    }

    public List<EntityPkg> getChildren() {
        return children;
    }

    public EntityPkg setChildren(List<EntityPkg> children) {
        this.children = children;
        return this;
    }
}
