package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.dao.mapper.CoatingMachineMapper;
import cn.edu.usts.cs2018.entity.CoatingMachine;
import cn.edu.usts.cs2018.entity.Item;
import cn.edu.usts.cs2018.utils.CoatingMachineConnectionManager;
import cn.edu.usts.cs2018.utils.DrawingMachineConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service(value = "coatingMachineService")
public class CoatingMachineServiceImpl implements Runnable,ICoatingMachineService {
    @Autowired
    CoatingMachineMapper mapper;
    @Autowired
    IItemService itemService;
    @Autowired
    CoatingMachineConnectionManager cmcm;
    Thread thread;
    public CoatingMachineServiceImpl(){
        thread=new Thread(this);
        thread.start();
    }
    @PostConstruct
    void init(){
        mapper.setAllAsBreakdown();
    }
    @Override
    public Boolean insert(CoatingMachine coatingMachine) {
        return mapper.insert(coatingMachine)>0;
    }

    @Override
    public Boolean update(CoatingMachine coatingMachine) {
        return mapper.update(coatingMachine)>0;
    }

    @Override
    public Boolean delete(int id) {
        return mapper.delete(id)>0;
    }

    @Override
    public CoatingMachine getMachine(int id) {
        return mapper.getMachine(id);
    }

    @Override
    public List<CoatingMachine> getMachinesByStatus(int status) {
        return mapper.getMachinesByStatus(status);
    }

    @Override
    public List<CoatingMachine> getAllMachines() {
        return mapper.getAllMachines();
    }

    @Override
    public List<CoatingMachine> getReadyMachines() {
        return getMachinesByStatus(0);
    }

    @Override
    public List<CoatingMachine> getProcessingMachines() {
        return getMachinesByStatus(1);
    }

    @Override
    public List<CoatingMachine> getBreakdownMachines() {
        return getMachinesByStatus(2);
    }

    @Override
    public void run() {
        while (true){
            try{
                List<CoatingMachine>readyMachines=getReadyMachines(); //TODO：可能得改
                List<Item>readyItems=itemService.getLimitedCountItemsForCoating(readyMachines.size());
                int n=Math.min(readyMachines.size(),readyItems.size());
                for(int i=0;i<n;i++)
                {
                    CoatingMachine machine=readyMachines.get(i);
                    machine.setStatus(1);
                    int itemId=readyItems.get(i).getId();
                    machine.setItemId(itemId);
                    update(machine);
                    itemService.sendToCoating(itemId,machine.getId());
                    //TODO: 向机台发送消息
                    cmcm.sendTaskMsg(machine.getId());
                }
                Thread.sleep(10000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    // TODO：从机台接收消息并处理
}
