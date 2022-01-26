package com.springbasics.java_annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.*;

@SpringBootApplication
public class JavaAnnotationApplication {

	public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach myCoach = context.getBean("myCoach", Coach.class);

        System.out.println(myCoach.getDailyWorkout());

        context.close();
	}


}
