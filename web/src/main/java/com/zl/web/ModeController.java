package com.zl.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/m")
public class ModeController {

    @ModelAttribute
    public void model1(@RequestParam("m_name") String name, Model model){
        System.out.println("model1 inovke ...");
        model.addAttribute("name",name);
    }

    @GetMapping("/hello")
    public String hello(Model model){
        Object name = model.getAttribute("name");
        System.out.println("name is "+name);
        return "hello";
    }

    @GetMapping("/h")
    @ResponseBody
    public String hello2(){

        return "hello";
    }

}
