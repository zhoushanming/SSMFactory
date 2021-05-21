package cn.edu.usts.cs2018.entity;

public class CoatingMachine {
    private int id;
    private int status;
    private int itemId;

    public CoatingMachine() {
    }
    public CoatingMachine(int id, int status, int itemId) {
        this.id = id;
        this.status = status;
        this.itemId = itemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
