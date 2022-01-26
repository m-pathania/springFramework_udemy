package com.springbasics.workout_app;

public class CricketCoach implements Coach{
    public Fortune fortune;
    public String Email;
    public String Team;
    public void setFortune(Fortune fortune){
        this.fortune = fortune;
    }
    public String getPlan(){
        return "Practice Helicopter Shot.";
    }
    public String getFortune(){
        return fortune.getFortune();
    }
    public void setEmail(String email){
        this.Email = email;
    }
    public void setTeam(String team){
        this.Team = team;
    }
    public String getEmail(){
        return this.Email;
    }
    public String getTeam(){
        return this.Team;
    }
}
