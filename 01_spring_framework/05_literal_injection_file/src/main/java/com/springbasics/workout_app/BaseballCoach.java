package com.springbasics.workout_app;

public class BaseballCoach implements Coach{
    public Fortune fortune;
    public BaseballCoach(Fortune fortune){
        this.fortune = fortune;
    }
    public String getPlan(){
        return "Swing bat for 30 min.";
    }
    public String getFortune(){
        return fortune.getFortune();
    }
}
