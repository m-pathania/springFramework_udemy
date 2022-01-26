package com.springmvc.basics.controllers;

import com.springmvc.basics.helper_classes.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/form")
    public String getStudentPage(Model model){
        model.addAttribute("student", new Student());

        return "studentForm";
    }

    @RequestMapping("/processed")
    public String getProcessedPage(@ModelAttribute("student") Student student){
        student.setFirstName(student.getFirstName().toUpperCase());
        student.setLastName(student.getLastName().toUpperCase());
        student.setCountry(student.getCountry().toUpperCase());
        return "studentProcessed";
    }
    
}
