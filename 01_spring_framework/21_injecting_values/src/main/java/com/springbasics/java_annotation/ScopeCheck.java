package com.springbasics.java_annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ScopeCheck {

    public static void main(String [] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NoXmlConfig.class);
        SwimCoach coach2 = context.getBean("thisWillBeBeanId", SwimCoach.class);

        System.out.println(coach2.getDailyWorkout());
        System.out.println(coach2.getFortuneMessage());
        System.out.println(coach2.getEmail());
        System.out.println(coach2.getTeam());

        context.close();
    }
    
}
