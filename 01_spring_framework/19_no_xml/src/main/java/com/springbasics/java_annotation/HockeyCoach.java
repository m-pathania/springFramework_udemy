package com.springbasics.java_annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HockeyCoach implements Coach{

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortune; 
    public String getDailyWorkout(){
        return "Practice Penalty shootouts.";
    }
    public String getFortuneMessage(){
        return fortune.getFortune();
    }

    @PostConstruct
    public void nameThisAnything(){
        System.out.println("\n\n\nPostConstruct: HockeyCoach");
    }
    @PreDestroy
    public void nameThisAnythingToo(){
        System.out.println("\n\n\nPreDestroy: HockeyCoach");
    }
}
