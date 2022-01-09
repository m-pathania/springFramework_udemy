package com.springbasics.java_annotation;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService{
    public String getFortune(){
        String [] randomFortune = {"This is your day!", "Rock the world", "Give your best", "Rab rakha"};
        Random rand = new Random(System.currentTimeMillis());
        return randomFortune[rand.nextInt(randomFortune.length)];
    }
    
}
