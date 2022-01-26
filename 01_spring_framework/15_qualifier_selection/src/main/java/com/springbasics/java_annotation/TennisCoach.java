package com.springbasics.java_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myCoach")
public class TennisCoach implements Coach{
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortune;

    public String getDailyWorkout(){
        return "Do 100 backhand swings.";
    }
    @Override
    public String getFortuneMessage() {
        return fortune.getFortune();
    }
}
