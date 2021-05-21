package cn.edu.usts.cs2018.controller;

import cn.edu.usts.cs2018.entity.CoatingMachine;
import cn.edu.usts.cs2018.entity.DrawingMachine;
import cn.edu.usts.cs2018.entity.Item;
import cn.edu.usts.cs2018.entity.MachineResult;
import cn.edu.usts.cs2018.service.ICoatingMachineService;
import cn.edu.usts.cs2018.service.IDrawingMachineService;
import cn.edu.usts.cs2018.service.IItemService;
import cn.edu.usts.cs2018.service.IMouldService;
import cn.edu.usts.cs2018.utils.CoatingMachineConnectionManager;
import cn.edu.usts.cs2018.utils.DrawingMachineConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MachineController {
    @Autowired
    IDrawingMachineService dmService;
    @Autowired
    ICoatingMachineService cmService;
    @Autowired
    IItemService itemService;
    @Autowired
    IMouldService mouldService;
    @Autowired
    DrawingMachineConnectionManager dmcm;
    @Autowired
    CoatingMachineConnectionManager cmcm;



    @GetMapping("/board/machineboard")
    public String machineBoardPage(Model model){
        List<DrawingMachine>dmls=dmService.getAllMachines();
        List<CoatingMachine>cmls=cmService.getAllMachines();
        List<MachineResult>dmList=new ArrayList<MachineResult>();
        for(DrawingMachine dm :dmls){
            MachineResult mr=new MachineResult(dm);
            if(dm.getStatus()>0)
            {
                SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
                try{
                    String time = sdf.format(dmcm.getLastActionTime(dm.getId()));
                    mr.setDate(time);
                }catch (Exception e){
                    mr.setDate("");
                    e.printStackTrace();
                }
            }
            dmList.add(mr);
        }
        model.addAttribute("dmList",dmList);
        List<MachineResult>cmList=new ArrayList<MachineResult>();
        for(CoatingMachine cm :cmls){
            MachineResult mr=new MachineResult(cm);
            if(cm.getStatus()>0)
            {
                SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
                try{
                    String time = sdf.format(dmcm.getLastActionTime(cm.getId()));
                    mr.setDate(time);
                }catch (Exception e){
                    mr.setDate("");
                    e.printStackTrace();
                }

            }
            cmList.add(mr);
        }
        model.addAttribute("cmList",cmList);
        return "board/machineboard";
    }

    @GetMapping("/machine/drawing/{id}")
    public String drawingMachineStatusPage(@PathVariable(name = "id") int id, Model model){
        DrawingMachine dm= dmService.getMachine(id);
        model.addAttribute("id",dm.getId());
        model.addAttribute("status",dm.getStatus());
        SimpleDateFormat sdf;
        String time;
        switch (dm.getStatus()){
            case 0:
                model.addAttribute("statusString","准备");
                break;
            case 1:
                model.addAttribute("statusString","工作中");
                model.addAttribute("itemId",dm.getItemId());
                Item item=itemService.getItem(dm.getItemId());
                model.addAttribute("mouldId",item.getMouldId());
                model.addAttribute("radius",mouldService.getMould(item.getMouldId()).getRadius());
                model.addAttribute("weight",item.getWeight());

                model.addAttribute("productionRate",String.format("%.2f",dmcm.getProductionRate(id)));
                model.addAttribute("progress",(String.format("%.2f",dmcm.getProgress(id)/item.getWeight()*100)));
                sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
                try {
                    time = sdf.format(dmcm.getLastActionTime(id));
                }catch (Exception e){
                    e.printStackTrace();
                    time="";
                }
                model.addAttribute("lastActionTime",time);
                break;
            case 2:
                model.addAttribute("statusString","故障");
                sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
                try {
                    time = sdf.format(dmcm.getLastActionTime(id));
                }catch (Exception e){
                    e.printStackTrace();
                    time="";
                }
                model.addAttribute("lastActionTime",time);
        }
        return "machine/machine";
    }

    @GetMapping("/machine/coating/{id}")
    public String coatingMachineStatusPage(@PathVariable(name = "id") int id, Model model){
        CoatingMachine cm= cmService.getMachine(id);
        model.addAttribute("id",cm.getId());
        model.addAttribute("status",cm.getStatus());
        SimpleDateFormat sdf;
        String time;
        switch (cm.getStatus()){
            case 0:
                model.addAttribute("statusString","准备");
                break;
            case 1:
                model.addAttribute("statusString","工作中");
                model.addAttribute("itemId",cm.getItemId());
                Item item=itemService.getItem(cm.getItemId());
                model.addAttribute("mouldId",item.getMouldId());
                model.addAttribute("radius",mouldService.getMould(item.getMouldId()).getRadius());
                model.addAttribute("weight",item.getWeight());

                model.addAttribute("productionRate",String.format("%.2f",cmcm.getProductionRate(id)));
                model.addAttribute("progress",(String.format("%.2f",cmcm.getProgress(id)/item.getWeight()*100)));
                sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
                try {
                    time = sdf.format(cmcm.getLastActionTime(id));
                }catch (Exception e){
                    e.printStackTrace();
                    time="";
                }
                model.addAttribute("lastActionTime",time);
                break;
            case 2:
                model.addAttribute("statusString","故障");
                sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
                try {
                    time = sdf.format(cmcm.getLastActionTime(id));
                }catch (Exception e){
                    e.printStackTrace();
                    time="";
                }
                model.addAttribute("lastActionTime",time);
        }
        return "machine/machine";
    }
}
