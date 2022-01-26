package com.springbasics.java_annotation;

import org.springframework.stereotype.Component;

@Component("myCoach")
public class TennisCoach implements Coach{
    
    public String getDailyWorkout(){
        return "Do 100 backhand swings.";
    }
}
