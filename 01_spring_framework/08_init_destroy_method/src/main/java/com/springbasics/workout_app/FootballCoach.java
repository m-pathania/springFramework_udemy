package com.springbasics.workout_app;

public class FootballCoach implements Coach{
    public Fortune fortune;
    public FootballCoach(Fortune fortune){
        this.fortune = fortune;
    }
    public String getPlan(){
        return "Dribble for 30 min.\nPassing for 1h.";
    }
    public String getFortune(){
        return fortune.getFortune();
    }
    public void initMethod(){
        System.out.println("Do Stuff: FootballCoach: init Method.");
    }
    public void destroyMethod(){
        System.out.println("Do Stuff: FootballCoach: Destroy Method.");
    }
    
}
