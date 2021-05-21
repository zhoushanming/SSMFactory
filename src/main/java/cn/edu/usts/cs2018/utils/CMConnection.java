package cn.edu.usts.cs2018.utils;

import cn.edu.usts.cs2018.dao.mapper.CoatingMachineMapper;
import cn.edu.usts.cs2018.dao.mapper.DrawingMachineMapper;
import cn.edu.usts.cs2018.entity.CoatingMachine;
import cn.edu.usts.cs2018.entity.DrawingMachine;
import cn.edu.usts.cs2018.entity.Item;
import cn.edu.usts.cs2018.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Date;

public class CMConnection implements Runnable{
    Socket socket;
    DataInputStream in;
    DataOutput out;
    Thread thread;
    public int id;
    public int status;
    public Date lastActionTime;
    public double productionRate;
    public double progress;
    @Autowired
    CoatingMachineMapper mapper;
    @Autowired
    IItemService itemService;
    @Override
    public void run() {
        while(true){
            try{
                String input=in.readUTF();
                String[] inputList=input.split(";");
                int status=Integer.parseInt(inputList[0]);
                switch (status){
                    case 0:
                    case 2:
                        if(status!=this.status){
                            CoatingMachine machine=mapper.getMachine(id);
                            machine.setStatus(status);
                            this.lastActionTime=new Date();
                            if(this.status==1&&status==0){
                                itemService.processComplete(machine.getItemId(),this.lastActionTime);
                            }
                            this.status=status;
                            mapper.update(machine);
                        }
                        break;
                    case 1:
                        this.status=1;
                        this.productionRate=Double.parseDouble(inputList[1]);
                        this.progress=Double.parseDouble(inputList[2]);
                        break;
                }
            }catch (Exception e){
                if(this.status!=2){
                    this.status=2;
                    this.lastActionTime=new Date();
                    CoatingMachine machine=mapper.getMachine(this.id);
                    machine.setStatus(2);
                    mapper.update(machine);
                }
            }
        }
    }
    public CMConnection(int id,Socket socket,CoatingMachineMapper mapper,IItemService itemService){
        this.socket=socket;
        try{
            this.mapper=mapper;
            this.itemService=itemService;
            this.id=id;
            this.status=-1;
            this.in=new DataInputStream(this.socket.getInputStream());
            this.out=new DataOutputStream(this.socket.getOutputStream());
            thread=new Thread(this);
            this.socket.setSoTimeout(10000);
            lastActionTime=new Date();
            thread.start();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public Boolean sendTaskMsg(){
        try{
            CoatingMachine machine=mapper.getMachine(id);
            Item item=itemService.getItem(machine.getItemId());
            String msg=String.format("%d;%d;%f",this.id,machine.getItemId(),item.getWeight());
            out.writeUTF(msg);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public Date getLastActionTime(){
        return this.lastActionTime;
    }
    public double getProductionRate(){
        return this.productionRate;
    }
    public double getProgress(){
        return this.progress;
    }
}
