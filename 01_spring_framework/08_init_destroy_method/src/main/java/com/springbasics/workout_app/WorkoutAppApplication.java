package com.springbasics.workout_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class WorkoutAppApplication {

	public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach1 = context.getBean("myCoach", Coach.class);
        System.out.println(coach1.getFortune());
        CricketCoach cricketCoach2 = context.getBean("myCricketCoach", CricketCoach.class);
        System.out.println(cricketCoach2.getEmail());
        
        context.close();
	}

}
