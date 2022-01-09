package com.springbasics.workout_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class WorkoutAppApplication {

	public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach1 = context.getBean("myCoach", Coach.class);
        Coach coach2 = context.getBean("myCoach", Coach.class);
        boolean areSame = (coach1 == coach2);
        System.out.println("coach1 and coach2 are same: " + areSame);
        System.out.println("Memory Address of coach1: " + coach1);
        System.out.println("Memory Address of coach2: " + coach2);

        CricketCoach cricketCoach1 = context.getBean("myCricketCoach", CricketCoach.class);
        CricketCoach cricketCoach2 = context.getBean("myCricketCoach", CricketCoach.class);
        areSame = (cricketCoach1 == cricketCoach2);

        System.out.println("\n\ncricketCoach1 and cricketCoach2 are same: " + areSame);
        System.out.println("Memory Address of cricketCoach1: " + cricketCoach1);
        System.out.println("Memory Address of cricketCoach2: " + cricketCoach2);
        
        context.close();
	}

}
