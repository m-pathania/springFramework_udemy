package com.springbasics.java_annotation;

import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach{
    
    public String getDailyWorkout(){
        return "Practice Penatly shootouts.";
    }
}
