package top.howard85.code.generator.entity;

import java.util.*;
import java.util.stream.Collectors;

public class EntityPkg {

    public static final String DOT = ".";
    public static final String DOT_REGEX = "\\.";

    private String name;

    private EntityPkg parent;

    private Set<EntityPkg> children = new HashSet<>();

    public EntityPkg() {
    }

    public EntityPkg(String name) {
        this.name = name;
    }

    public String fullName() {
        List<String> subs = new ArrayList<>();
        EntityPkg node = this;
        while (null != node) {
            subs.add(node.getName());
            node = node.getParent();
        }
        Collections.reverse(subs);
        return subs.stream().collect(Collectors.joining(DOT));
    }

    public static EntityPkg create(String pkg) {
        if (null == pkg || 0 == pkg.length()) {
            return null;
        }
        String[] subs = pkg.split(DOT_REGEX);
        EntityPkg subNode = null;
        for (String subName : subs) {
            if (null == subNode) {
                subNode = new EntityPkg(subName);
            } else {
                EntityPkg current = new EntityPkg(subName);
                current.setParent(subNode);
                subNode.addChild(current);
                subNode = current;
            }
        }
        return subNode;
    }

    public EntityPkg addChild(EntityPkg child) {
        this.children.add(child);
        return this;
    }

    public EntityPkg getParent() {
        return parent;
    }

    public EntityPkg setParent(EntityPkg parent) {
        this.parent = parent;
        return this;
    }

    public Set<EntityPkg> getChildren() {
        return children;
    }

    public EntityPkg setChildren(Set<EntityPkg> children) {
        this.children = children;
        return this;
    }

    public String getName() {
        return name;
    }

    public EntityPkg setName(String name) {
        this.name = name;
        return this;
    }
}
