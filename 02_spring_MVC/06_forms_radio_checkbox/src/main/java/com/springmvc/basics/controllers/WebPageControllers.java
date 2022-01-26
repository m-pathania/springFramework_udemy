package com.springmvc.basics.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/formPage2")
    public String showFormPage2(){
        return "formPage2";
    }

    @RequestMapping("/shoutoutPage")
    public String showShoutPage(@RequestParam("personName") String name,
                                @RequestParam("number1") String num1, 
                                @RequestParam("number2") String num2,
                                Model model){
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        name = name.toUpperCase();
        model.addAttribute("personName", name);
        model.addAttribute("prod", String.valueOf(n1*n2));
        model.addAttribute("add", String.valueOf(n1+n2));

        return "shoutoutPage";
    }
}
