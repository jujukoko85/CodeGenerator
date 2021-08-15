package top.howard85.code.generator.db;

public class DBColumn {

    private String name; //

    private DBColumnType type;

    private String comment;

    public String getName() {
        return name;
    }

    public DBColumn setName(String name) {
        this.name = name;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public DBColumn setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public DBColumnType getType() {
        return type;
    }

    public DBColumn setType(DBColumnType type) {
        this.type = type;
        return this;
    }
}
