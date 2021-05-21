package cn.edu.usts.cs2018.entity;

public class Plan {
    private int id;
    private int amount;
    private int spec;

    public Plan() {
    }
    public Plan(int id, int amount, int spec) {
        this.id = id;
        this.amount = amount;
        this.spec = spec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSpec() {
        return spec;
    }

    public void setSpec(int spec) {
        this.spec = spec;
    }
}
