package com.springbasics.java_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach{
    private FortuneService fortune;

    @Autowired
    public void canBeAnyName(FortuneService fortune){
        this.fortune = fortune;
    }
    
    public String getDailyWorkout(){
        return "Practice Penalty shootouts.";
    }
    public String getFortuneMessage(){
        return fortune.getFortune();
    }
}
