package cn.edu.usts.cs2018.entity;

public class Mould {
    private int id;
    private Double radius;
    private Double length;

    public Mould() {
    }

    public Mould(int id, Double radius, Double length) {
        this.id = id;
        this.radius = radius;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}
