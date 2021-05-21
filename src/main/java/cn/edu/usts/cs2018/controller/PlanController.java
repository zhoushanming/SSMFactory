package cn.edu.usts.cs2018.controller;

import cn.edu.usts.cs2018.entity.ActionResult;
import cn.edu.usts.cs2018.entity.Plan;
import cn.edu.usts.cs2018.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PlanController {
    @Autowired
    IPlanService service;

    @GetMapping("/api/plan/plan")
    @ResponseBody
    public Plan getPlan(int id){
        return service.getPlan(id);
    }
    @GetMapping("/api/plan/list")
    @ResponseBody
    public List<Plan>getPlans(){
        return service.getPlans();
    }
    @PostMapping("/api/plan/new")
    @ResponseBody
    public ActionResult insert(Plan plan){
        return new ActionResult(service.insert(plan));
    }
    @PostMapping("/api/plan/update")
    @ResponseBody
    public ActionResult update(Plan plan){
        return new ActionResult(service.update(plan));
    }
    @RequestMapping("/api/plan/delete")
    @ResponseBody
    public ActionResult delete(int id){
        return new ActionResult(service.delete(id));
    }
}
