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

        try{
            Session curSession = factory.getCurrentSession();
            
            curSession.beginTransaction();
            Student student = curSession.get(Student.class, 3);
            System.out.println(student);
            student.setFirstName("Jackson");
            System.out.println(student);
            curSession.getTransaction().commit();

            curSession = factory.getCurrentSession();
            curSession.beginTransaction();

            curSession.createQuery("update Student set email='fooBar@emal.com' where first_name='Jackson'").executeUpdate();
            curSession.getTransaction().commit();

            curSession = factory.getCurrentSession();
            curSession.beginTransaction();

            List<Student> students = curSession.createQuery("from Student").getResultList();
            print(students);
            curSession.getTransaction().commit();
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
