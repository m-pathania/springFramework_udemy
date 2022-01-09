package com.springbasics.java_annotation;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{
    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

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
    
    public String getEmail() {
        return this.email;
    }
    public String getTeam() {
        return this.team;
    }
}
