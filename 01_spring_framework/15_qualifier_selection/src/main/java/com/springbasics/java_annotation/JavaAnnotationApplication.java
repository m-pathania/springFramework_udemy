package com.springbasics.java_annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class JavaAnnotationApplication {

	public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach myCoach = context.getBean("hockeyCoach", Coach.class);

        System.out.println(myCoach.getDailyWorkout());
        System.out.println(myCoach.getFortuneMessage());

        context.close();
	}


}
