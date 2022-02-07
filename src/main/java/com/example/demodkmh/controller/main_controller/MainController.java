package com.example.demodkmh.controller.main_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/403")
    public String error403(){
        return "/403";
    }
}
