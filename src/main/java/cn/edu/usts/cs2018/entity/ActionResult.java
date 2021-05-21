package cn.edu.usts.cs2018.entity;

public class ActionResult {
    private boolean Success;
    public ActionResult() {
    }
    public ActionResult(boolean success) {
        Success = success;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }
}
