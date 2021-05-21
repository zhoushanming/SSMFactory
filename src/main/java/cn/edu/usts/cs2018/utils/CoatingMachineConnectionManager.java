package cn.edu.usts.cs2018.utils;

import cn.edu.usts.cs2018.dao.mapper.CoatingMachineMapper;
import cn.edu.usts.cs2018.dao.mapper.DrawingMachineMapper;
import cn.edu.usts.cs2018.entity.CoatingMachine;
import cn.edu.usts.cs2018.entity.DrawingMachine;
import cn.edu.usts.cs2018.entity.Item;
import cn.edu.usts.cs2018.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("cmcm")
public class CoatingMachineConnectionManager implements Runnable {

    ServerSocket ss;
    Thread thread;
    static List<CMConnection> connections;
    @Autowired
    CoatingMachineMapper mapper;
    @Autowired
    IItemService itemService;
    @Override
    public void run() {
        while(true){
            try {
                Socket socket=ss.accept();
                connections.add(new CMConnection(connections.size()+1,socket,mapper,itemService));
            }catch (Exception e){

            }
        }
    }
    public CoatingMachineConnectionManager(){
        System.out.println("CMCM Created");
        try{
            connections=new ArrayList<CMConnection>();
            ss=new ServerSocket(12450);
            thread=new Thread(this);
            thread.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public Boolean sendTaskMsg(int id){
        return connections.get(id-1).sendTaskMsg();
    }
    public Date getLastActionTime(int id){
        return connections.get(id-1).getLastActionTime();
    }
    public double getProductionRate(int id){
        return connections.get(id-1).getProductionRate();
    }
    public double getProgress(int id){
        return connections.get(id-1).getProgress();
    }
}
