package com.springbasics.java_annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ScopeCheck {

    public static void main(String [] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NoXmlConfig.class);
        Coach coach2 = context.getBean("thisWillBeBeanId", Coach.class);

        System.out.println(coach2.getDailyWorkout());
        System.out.println(coach2.getFortuneMessage());

        context.close();
    }
    
}
