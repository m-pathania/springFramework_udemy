package com.springbasics.java_annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService{
    public String getFortune(){
        return "Hardword pays!";
    }
    
    @PostConstruct
    public void nameThisAnything(){
        System.out.println("\n\n\nPostConstruct: HappyFortuneService");
    }
    @PreDestroy
    public void nameThisAnythingToo(){
        System.out.println("\n\n\nPreDestroy: HappyFortuneService");
    }
}
