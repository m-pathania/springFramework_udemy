package com.springbasics.java_annotation;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService{
    public String getFortune(){
        return "Hardword pays!";
    }
    
}
