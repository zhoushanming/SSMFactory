package cn.edu.usts.cs2018.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class MachineSimulatorSender implements Runnable {
    DataOutputStream out;
    public int status;
    public int itemId;
    public double weight;
    public double productionRate;
    public double progress;
    Thread thread;
    @Override
    public void run() {
        while (true){
            try{
                if(status==1){
                    progress+=productionRate;
                    if(progress>=weight){
                        status=0;
                    }
                }
                if(status==1){
                    out.writeUTF(String.format("%d;%f;%f",status,productionRate,progress));
                }else {
                    out.writeUTF(String.format("%d",status));
                }
                thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public MachineSimulatorSender(DataOutputStream out){
        this.out=out;
        this.status=0;
        thread=new Thread(this);
        thread.start();
    }
    public void setTaskData(int itemId,double weight,double productionRate){
        this.itemId=itemId;
        this.weight=weight;
        this.productionRate=productionRate;
        this.progress=0;
        this.status=1;
    }
}
