package com.hibernate_basics.mapping;

import com.hibernate_basics.mapping.instructor.Instructor;
import com.hibernate_basics.mapping.instructor.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        try{
            Session curSession = factory.getCurrentSession();

            int tempId = 1;
            curSession.beginTransaction();
            Instructor tempInstructor = curSession.get(Instructor.class, tempId);
            if(tempInstructor != null){
                System.out.println(tempInstructor + "\n\n\n");
                curSession.delete(tempInstructor);
            }
            curSession.getTransaction().commit();
        }finally{
            factory.close();
        }
    }
}
