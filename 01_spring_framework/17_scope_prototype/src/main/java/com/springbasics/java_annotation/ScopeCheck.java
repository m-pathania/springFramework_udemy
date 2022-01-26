package com.springbasics.java_annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ScopeCheck {

    public static void main(String [] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach1 = context.getBean("hockeyCoach", Coach.class);
        Coach coach2 = context.getBean("hockeyCoach", Coach.class);
        boolean check = (coach1 == coach2);

        System.out.println(check);
        System.out.println(coach1);
        System.out.println(coach2);

        context.close();
    }
    
}
