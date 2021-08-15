package top.howard85.code.generator.db;

public class DBTable {

    private String name;

    private DBColumn id;

    private String comment;

    public String getName() {
        return name;
    }

    public DBTable setName(String name) {
        this.name = name;
        return this;
    }

    public DBColumn getId() {
        return id;
    }

    public DBTable setId(DBColumn id) {
        this.id = id;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public DBTable setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
