package com.hibernate.basics;

import com.hibernate.basics.helper_classes.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicsApplication {
	public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session curSession = factory.getCurrentSession();

        try{
            Student tempStudent = new Student("Mayank", "Pathania", "temp@email.com");
            System.out.println(tempStudent.toString());

            curSession.beginTransaction();

            curSession.save(tempStudent);

            curSession.getTransaction().commit();
            System.out.println("Commited Successfully\n\n\n");
        }finally{
            factory.close();
        }
	}
}
