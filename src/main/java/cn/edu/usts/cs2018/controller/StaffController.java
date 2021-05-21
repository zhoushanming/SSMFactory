package cn.edu.usts.cs2018.controller;

import cn.edu.usts.cs2018.entity.ActionResult;
import cn.edu.usts.cs2018.entity.Staff;
import cn.edu.usts.cs2018.service.IStaffService;
import cn.edu.usts.cs2018.service.ValidateCodeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@Controller
public class StaffController {
    @Autowired
    IStaffService service;
    @Autowired
    private ValidateCodeService codeGen;
    private static Logger logger = Logger.getLogger(StaffController.class);

    @PostMapping("api/staff/login")
    public String login(HttpServletRequest request, Model model) {
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        String logyzm = request.getParameter("logyzm");
        String redirect=request.getParameter("redirect");
        HttpSession session = request.getSession();
        Staff user = service.getStaffByName(name);
        String resultView = "login";
        String currectCode = session.getAttribute("ValidateCode").toString().toUpperCase();
        if (user != null && user.getPassword().equals(pwd) && logyzm.toUpperCase().equals(currectCode)) {
            System.out.println("成功");
            logger.info(user);

            session.removeAttribute("User");
            session.removeAttribute("user");

            session.setAttribute("User", user);      // 用户登录成功的信息写入Session中。
            session.setAttribute("user", user);
            resultView = "redirect:empty";
            if(redirect!=null && !redirect.equals("")){
                return "redirect:"+redirect.replaceAll("%2F","/");
            }
        }
        else
        {
            model.addAttribute("hint","用户名或密码错误");
            model.addAttribute("redirect",redirect);
        }
        logger.info(resultView);
        return resultView;
    }

    @PostMapping("api/staff/register")
    @ResponseBody
    public ActionResult register(Staff staff){
        return new ActionResult(service.insert(staff));
    }
    @PostMapping("api/staff/resetPassword")
    @ResponseBody
    public ActionResult resetPassword(HttpSession session,String newpassword){
        Staff staff=(Staff)session.getAttribute("user");
        staff.setPassword(newpassword);
        return new ActionResult(service.update(staff));
    }
    @PostMapping("api/staff/update")
    @ResponseBody
    public ActionResult update(Staff staff){
        return new ActionResult(service.update(staff));
    }
    @GetMapping("api/staff/list")
    @ResponseBody
    public List<Staff> getStaffList(){
        return service.getStaffList();
    }
    @ResponseBody
    @RequestMapping("api/validatecode/validate")
    public ActionResult validateCode(@RequestParam String logyzm, HttpSession session){
        String currectCode=session.getAttribute("ValidateCode").toString().toUpperCase();
        return new ActionResult(currectCode.equals(logyzm.toUpperCase()));
    }
    @RequestMapping("api/validatecode/get")
    public void getCode(HttpServletResponse response, HttpSession session){
        response.setContentType("image/jpeg");
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", 0);
        int width=60, height=30;
        BufferedImage codeImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        String code=codeGen.genValidate(codeImage);
        session.setAttribute("ValidateCode",code);
        try{
            ImageIO.write(codeImage, "JPEG", response.getOutputStream());
        }catch(IOException e ){}
        try{
            response.flushBuffer();
        }catch (Exception e){}

    }
}
