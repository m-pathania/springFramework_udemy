package com.springbasics.java_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach{

    @Autowired
    private FortuneService fortune; 
    public String getDailyWorkout(){
        return "Practice Penalty shootouts.";
    }
    public String getFortuneMessage(){
        return fortune.getFortune();
    }
}
