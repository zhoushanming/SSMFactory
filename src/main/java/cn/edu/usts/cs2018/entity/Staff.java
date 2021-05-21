package cn.edu.usts.cs2018.entity;

public class Staff {
    private int id;
    private String name;
    private String password;
    private String position;

    public Staff() {
    }

    public Staff(int id, String password, String name, String position) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
