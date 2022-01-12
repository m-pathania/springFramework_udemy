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
            Student student0 = new Student("person1", "Pathania", "temp0@email.com");
            Student student1 = new Student("person2", "Pathania", "temp4@email.com");
            Student student2 = new Student("person3", "Pathania", "temp2@email.com");
            Student student3 = new Student("person4", "Pathania", "temp3@email.com");

            curSession.beginTransaction();

            curSession.save(student0);
            curSession.save(student1);
            curSession.save(student3);
            curSession.save(student2);

            System.out.println(student0);
            System.out.println(student1);
            System.out.println(student2);
            System.out.println(student3);
            System.out.println("\n\n\n");

            curSession.getTransaction().commit();
            System.out.println("Commited Successfully\n\n\n");

            //Retrieving Student
            Session thisSession = factory.getCurrentSession();
            thisSession.beginTransaction();

            Student student = thisSession.get(Student.class, student0.getId());
            System.out.println(student);

            thisSession.getTransaction().commit();
        }finally{
            factory.close();
        }
	}
}
