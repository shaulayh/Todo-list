package com.shaulayh.controller;

import com.shaulayh.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

//    @GetMapping("/welcome")
//    public String welcome(Model model) {
//        model.addAttribute("name", demoService.getWelcomeMessage())
//        return "welcome";
//    }

    @ModelAttribute("name")
    @GetMapping("welcome")
    public String welcomeMessage(@RequestParam String user) {
        return demoService.getHelloMessage(user);
    }
}
