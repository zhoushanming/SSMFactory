package cn.edu.usts.cs2018.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    @GetMapping("board")
    public String BoardPage(){
        return "board";
    }
    @GetMapping("products/plan")
    public String productPlansPage(){
        return "products/productplans";
    }
    @GetMapping("products/mould")
    public String mouldManagementPage(){
        return "products/mouldmanagement";
    }
    @GetMapping("products/raw")
    public String rawProductsPage(){
        return "products/rawproducts";
    }
    @GetMapping("products/semi")
    public String semiProductsPage(){
        return "products/semiproducts";
    }
    @GetMapping("products/end")
    public String endProductsPage(){
        return "products/endproducts";
    }
    @GetMapping("/machine/drawing")
    public String drawingMachinePage(){
        return "machine/drawingmachines";
    }
    @GetMapping("/machine/coating")
    public String coatingMachinePage(){
        return "machine/coatingmachines";
    }
    @GetMapping("login")
    public String loginPage(@RequestParam(defaultValue = "") String redirect, Model model){
        model.addAttribute("redirect",redirect);
        return "/login";
    }
    @GetMapping("staff/resetpassword")
    public String resetPasswordPage(){
        return "staff/resetpassword";
    }
    @GetMapping("staff/management")
    public String staffManagementPage(){
        return "staff/staffmanagement";
    }
    @GetMapping("empty")
    public String emptyPage(){
        return "empty";
    }
}
