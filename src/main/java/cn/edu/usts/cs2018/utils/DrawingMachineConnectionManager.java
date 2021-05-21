package cn.edu.usts.cs2018.utils;


import cn.edu.usts.cs2018.dao.mapper.DrawingMachineMapper;
import cn.edu.usts.cs2018.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

@Repository(value = "dmcm")
public class DrawingMachineConnectionManager implements Runnable{

    ServerSocket ss;
    Thread thread;
    static Vector<DMConnection> connections;
    @Autowired
    DrawingMachineMapper mapper;
    @Autowired
    IItemService itemService;
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("DMCM Accepter");
                Socket socket=ss.accept();
                connections.add(new DMConnection(connections.size()+1,socket,mapper,itemService));
                System.out.println();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public DrawingMachineConnectionManager(){

        try{
            connections=new Vector<DMConnection>();
            ss=new ServerSocket(23333);
            thread=new Thread(this);
            thread.start();
            System.out.println("DMCM Created");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public Boolean sendTaskMsg(int id){
        System.out.println("STM");
        return connections.get(id-1).sendTaskMsg();
    }
    public Date getLastActionTime(int id){
        return connections.get(id-1).getLastActionTime();
    }
    public double getProductionRate(int id){
        System.out.println("GPR");
        System.out.println(id);
        System.out.println(connections.get(id-1)==null);
        return connections.get(id-1).getProductionRate();
    }
    public double getProgress(int id){
        return connections.get(id-1).getProgress();
    }
}
