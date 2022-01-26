package com.springbasics.workout_app;

import java.util.Random;

public class HappyFortune implements Fortune{
    public String getFortune(){
        String[] fortunes = {"Keep pushing you can do it.", "This is your day champ.", "Sweat makes a man."};
        Random rand = new Random(System.currentTimeMillis());
        return fortunes[rand.nextInt(3)];
    }
    
}
