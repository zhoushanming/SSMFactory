package cn.edu.usts.cs2018.entity;

public class MachineResult {
    private int id;
    private int status;
    private int itemId;
    private String statusStr;
    private String date;
    public MachineResult(){

    }
    public MachineResult(DrawingMachine machine){
        id=machine.getId();
        status=machine.getStatus();
        switch (status){
            case 0:
                statusStr="准备";
                break;
            case 1:
                statusStr="工作中";
                itemId=machine.getItemId();
                break;
            case 2:
                statusStr="故障";
                break;
        }
    }
    public MachineResult(CoatingMachine machine){
        id=machine.getId();
        status=machine.getStatus();
        switch (status){
            case 0:
                statusStr="准备";
                break;
            case 1:
                statusStr="工作中";
                itemId=machine.getItemId();
                break;
            case 2:
                statusStr="故障";
                break;
        }
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

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
