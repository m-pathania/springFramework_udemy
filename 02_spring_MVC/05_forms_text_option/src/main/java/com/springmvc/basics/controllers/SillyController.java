package com.springmvc.basics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/silly")
public class SillyController {
    @RequestMapping("/helloPage")
    public String sillyController(){
        return "sillyPage";
    }
    
}
