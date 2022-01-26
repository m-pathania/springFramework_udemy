package com.springbasics.java_annotation;

public class SwimCoach implements Coach{
    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim for 100m";
    }

    @Override
    public String getFortuneMessage() {
        return fortuneService.getFortune();
    }
    
}
