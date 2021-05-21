package cn.edu.usts.cs2018.entity;

import java.util.Date;

public class Item {
    private int id;
    private int state;
    private int mouldId;
    private Date date;
    private Double weight;
    private int drawingMachineId;
    private int coatingMachineId;
    private int curentState;

    public Item() {
    }
    public Item(int id, int state, int mouldId, Date date, Double weight, int drawingMachineId, int coatingMachineId, int curentState) {
        this.id = id;
        this.state = state;
        this.mouldId = mouldId;
        this.date = date;
        this.weight = weight;
        this.drawingMachineId = drawingMachineId;
        this.coatingMachineId = coatingMachineId;
        this.curentState = curentState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getDrawingMachineId() {
        return drawingMachineId;
    }

    public void setDrawingMachineId(int drawingMachineId) {
        this.drawingMachineId = drawingMachineId;
    }

    public int getCoatingMachineId() {
        return coatingMachineId;
    }

    public void setCoatingMachineId(int coatingMachineId) {
        this.coatingMachineId = coatingMachineId;
    }

    public int getCurentState() {
        return curentState;
    }

    public void setCurentState(int curentState) {
        this.curentState = curentState;
    }

    public int getMouldId() {
        return mouldId;
    }

    public void setMouldId(int mouldId) {
        this.mouldId = mouldId;
    }
}
