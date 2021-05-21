package cn.edu.usts.cs2018.controller;

import cn.edu.usts.cs2018.entity.ActionResult;
import cn.edu.usts.cs2018.entity.Mould;
import cn.edu.usts.cs2018.service.IMouldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MouldController {
    @Autowired
    IMouldService service;
    @GetMapping("/api/mould/mould")
    @ResponseBody
    public Mould getMould(int id){
        return service.getMould(id);
    }
    @GetMapping("/api/mould/list")
    @ResponseBody
    public List<Mould> getMoulds(){
        return service.getMoulds();
    }
    @PostMapping("/api/mould/new")
    @ResponseBody
    public ActionResult insert(Mould mould){
        return new ActionResult(service.insert(mould));
    }
    @PostMapping("/api/mould/update")
    @ResponseBody
    public ActionResult update(Mould mould){
        return new ActionResult(service.update(mould));
    }
    @RequestMapping("/api/mould/delete")
    @ResponseBody
    public ActionResult delete(int id){
        return new ActionResult(service.delete(id));
    }
}
