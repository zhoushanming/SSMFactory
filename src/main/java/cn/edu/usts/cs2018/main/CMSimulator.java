package cn.edu.usts.cs2018.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Random;

public class CMSimulator implements Runnable{

    Socket socket;
    Thread thread;
    DataInputStream in;
    DataOutputStream out;
    MachineSimulatorSender sender;
    @Override
    public void run() {
        while (true){
            try{
                String msg=in.readUTF();
                String[] msgList=msg.split(";");
                int itemId=Integer.parseInt(msgList[1]);
                double weight=Double.parseDouble(msgList[2]);
                Random random=new Random();
                double productionRate=random.nextDouble()+0.5;
                sender.setTaskData(itemId,weight,productionRate);
                thread.sleep(1000);
            }catch (Exception e){

            }

        }
    }
    public CMSimulator(int id){
        try{
            socket=new Socket("localhost",12450);
            in=new DataInputStream(socket.getInputStream());
            out=new DataOutputStream(socket.getOutputStream());
            sender=new MachineSimulatorSender(out);
            thread=new Thread(this);
            thread.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
