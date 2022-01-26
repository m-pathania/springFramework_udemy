package com.springbasics.java_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myCoach")
public class TennisCoach implements Coach{
    private FortuneService fortune;

    @Autowired
    public TennisCoach(FortuneService fortune){
        this. fortune = fortune;
    }
    public String getDailyWorkout(){
        return "Do 100 backhand swings.";
    }
    @Override
    public String getFortuneMessage() {
        return fortune.getFortune();
    }
}
