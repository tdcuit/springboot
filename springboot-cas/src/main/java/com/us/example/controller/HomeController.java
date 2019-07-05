package com.us.example.controller;

import com.us.example.domain.Msg;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangyibo on 17/1/18.
 */
@RestController
public class HomeController {

    @RequestMapping("/login")
    public String index(Model model){
        Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }

    @Secured("ROLE_USER")
    @RequestMapping("/test")
    public String test(Model model){
        return "home";
    }

    @Secured("ROLE_TEST")
    @RequestMapping("/test2")
    public String test2(Model model){
        return "home";
    }
}
