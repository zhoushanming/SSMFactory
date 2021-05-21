package cn.edu.usts.cs2018.controller;

import cn.edu.usts.cs2018.entity.ActionResult;
import cn.edu.usts.cs2018.entity.Item;
import cn.edu.usts.cs2018.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    IItemService service;


    @GetMapping("board/taskboard")
    public String taskBoardPage(Model model){
        int totalCount=service.getItems().size();
        int finishedCount=service.getEndItems().size();
        int unprocessedCount=service.getItemsByStateAndCurrentState(0,0).size();
        int processingCount=totalCount-finishedCount-unprocessedCount;
        double rate=100.0*finishedCount/totalCount;
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("processingCount",processingCount);
        model.addAttribute("finishedCount",finishedCount);
        model.addAttribute("rate",String.format("%.2f",rate));
        return "board/taskboard";
    }



    @GetMapping("api/item/item")
    @ResponseBody
    public Item getItem(int id){
        return service.getItem(id);
    }

    @GetMapping("api/item/all")
    @ResponseBody
    public List<Item> getItems(){
        return service.getItems();
    }

    @GetMapping("api/item/raw")
    @ResponseBody
    public List<Item>getRawItems() {
        return service.getRawItems();
    }

    @GetMapping("api/item/semi")
    @ResponseBody
    public List<Item>getSemiItems() {
        return service.getSemiItems();
    }

    @GetMapping("api/item/end")
    @ResponseBody
    public List<Item>getEndItems() {
        return service.getEndItems();
    }

    @PostMapping("api/item/new")
    @ResponseBody
    public ActionResult insert(Item item){
        return new ActionResult(service.insert(item));
    }
    @PostMapping("api/item/update")
    @ResponseBody
    public ActionResult update(Item item){
        return new ActionResult(service.update(item));
    }
    @RequestMapping("api/item/delete")
    public ActionResult delete(int id){
        return new ActionResult(service.delete(id));
    }
}
