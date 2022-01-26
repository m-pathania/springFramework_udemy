package com.hibernate_basics.one2many;

import com.hibernate_basics.one2many.course.Course;
import com.hibernate_basics.one2many.instructor.Instructor;
import com.hibernate_basics.one2many.instructor.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructors {
    public static void main(String [] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Instructor inst1 = session.get(Instructor.class, 1);
            Instructor inst2 = session.get(Instructor.class, 2);
 
            System.out.println("\n\n\n\n" + inst1 + "\n\n" + inst2 + "\n\n\n\n");

            session.getTransaction().commit();
        }finally{
            factory.close();
        }
    }

    public static void save(Session session, Course course){
        session.save(course);
        System.out.println("\n\n\n" + course + "\n\n\n");
    }
}
