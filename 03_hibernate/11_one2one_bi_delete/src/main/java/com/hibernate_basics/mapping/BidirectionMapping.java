package com.hibernate_basics.mapping;

import com.hibernate_basics.mapping.instructor.Instructor;
import com.hibernate_basics.mapping.instructor.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectionMapping {
    public static void main(String[] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        try{
            Session currSession = factory.getCurrentSession();

            currSession.beginTransaction();

            Instructor tempInstructor = new Instructor("Last Test", "This name", "retrospect@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("jack.pass.com", "Cricket", tempInstructor);
            
            currSession.save(tempInstructorDetail);

            currSession.getTransaction().commit();
            
            currSession = factory.getCurrentSession();
            
            currSession.beginTransaction();
            
            InstructorDetail tempInstructorDetail2 = currSession.get(InstructorDetail.class, 4);

            System.out.println("\n\n\n"+tempInstructorDetail);
            System.out.println(tempInstructor);
            System.out.println(tempInstructorDetail2);
            System.out.println(tempInstructorDetail2.getInstructor()+"\n\n\n");

            currSession.getTransaction().commit();
        }finally{
            factory.close();
        }
    }
}
