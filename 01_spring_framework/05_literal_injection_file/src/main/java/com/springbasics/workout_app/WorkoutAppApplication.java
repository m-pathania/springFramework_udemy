package com.springbasics.workout_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class WorkoutAppApplication {

	public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CricketCoach myCoach = context.getBean("myCricketCoach", CricketCoach.class);
        System.out.println(myCoach.getPlan());
        System.out.println(myCoach.getFortune());
        System.out.println(myCoach.getEmail());
        System.out.println(myCoach.getTeam());
        context.close();
	}

}
