package com.springbasics.workout_app;

public class TrackCoach implements Coach{
    public Fortune fortune;
    public TrackCoach(Fortune fortune){
        this.fortune = fortune;
    }  
    public String getPlan(){
       return "Run hard 5K.";
    } 
    public String getFortune(){
        return fortune.getFortune();
    }
}
