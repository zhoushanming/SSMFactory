package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.dao.mapper.DrawingMachineMapper;
import cn.edu.usts.cs2018.entity.DrawingMachine;
import cn.edu.usts.cs2018.entity.Item;
import cn.edu.usts.cs2018.utils.DrawingMachineConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service(value = "drawingMachineService")
public class DrawingMachineServiceImpl implements Runnable,IDrawingMachineService {
    @Autowired
    DrawingMachineMapper mapper;
    @Autowired
    IItemService itemService;
    @Autowired
    DrawingMachineConnectionManager dmcm;
    Thread thread;
    public DrawingMachineServiceImpl(){
        thread=new Thread(this);
        thread.start();
    }
    @PostConstruct
    void init(){
        mapper.setAllAsBreakdown();
    }
    @Override
    public Boolean insert(DrawingMachine drawingMachine) {
        return mapper.insert(drawingMachine)>0;
    }

    @Override
    public Boolean update(DrawingMachine drawingMachine) {
        return mapper.update(drawingMachine)>0;
    }

    @Override
    public Boolean delete(int id) {
        return mapper.delete(id)>0;
    }

    @Override
    public DrawingMachine getMachine(int id) {
        return mapper.getMachine(id);
    }

    @Override
    public List<DrawingMachine> getMachinesByStatus(int status) {
        return mapper.getMachinesByStatus(status);
    }

    @Override
    public List<DrawingMachine> getAllMachines() {
        return mapper.getAllMachines();
    }

    @Override
    public List<DrawingMachine> getReadyMachines() {
        return mapper.getMachinesByStatus(0);
    }

    @Override
    public List<DrawingMachine> getProcessingMachines() {
        return mapper.getMachinesByStatus(1);
    }

    @Override
    public List<DrawingMachine> getBreakdownMachines() {
        return mapper.getMachinesByStatus(2);
    }

    @Override
    public void run() {
        while (true){
            try{
                List<DrawingMachine>readyMachines=getReadyMachines(); //TODO：可能得改
                List<Item>readyItems=itemService.getLimitedCountItemsForDrawing(readyMachines.size());
                int n=Math.min(readyMachines.size(),readyItems.size());
                for(int i=0;i<n;i++)
                {
                    DrawingMachine machine=readyMachines.get(i);
                    machine.setStatus(1);
                    int itemId=readyItems.get(i).getId();
                    machine.setItemId(itemId);
                    update(machine);
                    itemService.sendToDrawing(itemId,machine.getId());
                    //TODO: 向机台发送消息
                    System.out.println(dmcm.sendTaskMsg(machine.getId()));
                }
                Thread.sleep(10000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    // TODO：从机台接收消息并处理
}
