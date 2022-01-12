package com.hibernate.basics;

import java.util.List;

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
            curSession.beginTransaction();

            List<Student> allStudents = curSession.createQuery("from Student").getResultList();
            print(allStudents);

            List<Student> moreStudents = curSession.createQuery("from Student s where s.lastName='Pathania'").getResultList();
            System.out.println("Students with last name Pathania");
            print(moreStudents);

            curSession.getTransaction().commit();


            Session newSession = factory.getCurrentSession();
            newSession.beginTransaction();
            List<Student> someMoreStudents = newSession.createQuery("from Student s where s.lastName = 'Pathania' AND s.firstName='Mayank'").getResultList();
            print(someMoreStudents);

            List<Student> students = newSession.createQuery("from Student s where s.email LIKE '%email.com'").getResultList();
            print(students);

            newSession.getTransaction().commit();
        }finally{
            factory.close();
        }
	}
    public static void print(List<Student> studentList){
        for(Student student: studentList){
            System.out.println(student);
        }
    }
}
