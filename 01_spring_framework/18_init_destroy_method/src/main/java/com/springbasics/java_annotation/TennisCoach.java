package com.springbasics.java_annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

    @PostConstruct
    public void nameThisAnything(){
        System.out.println("\n\n\nPostConstruct: TennisCoach");
    }
    @PreDestroy
    public void nameThisAnythingToo(){
        System.out.println("\n\n\nPreDestroy: TennisCoach");
    }

}
