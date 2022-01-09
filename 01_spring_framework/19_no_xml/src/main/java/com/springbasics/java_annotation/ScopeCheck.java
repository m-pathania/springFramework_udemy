package com.springbasics.java_annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ScopeCheck {

    public static void main(String [] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NoXmlConfig.class);
        Coach coach1 = context.getBean("hockeyCoach", Coach.class);
        Coach coach2 = context.getBean("myCoach", Coach.class);
        boolean check = (coach1 == coach2);

        System.out.println(check);
        System.out.println(coach1.getDailyWorkout());
        System.out.println(coach2.getDailyWorkout());

        context.close();
    }
    
}
