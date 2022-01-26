package com.springmvc.basics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebPageControllers {

    @RequestMapping("/")
    public String showHome(){
        return "index";
    }
    
    @RequestMapping("/formPage")
    public String showFormPage(){
        return "formPage";
    }

    @RequestMapping("/helloPage")
    public String showHelloPage(){
        return "helloPage";
    }
}
