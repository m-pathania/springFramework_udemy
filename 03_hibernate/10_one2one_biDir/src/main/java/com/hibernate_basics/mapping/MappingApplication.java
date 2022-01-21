package com.hibernate_basics.mapping;

import com.hibernate_basics.mapping.instructor.Instructor;
import com.hibernate_basics.mapping.instructor.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingApplication {

	public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        try{
            Session curSession = factory.getCurrentSession();
            
            InstructorDetail tempInstructorDetail = new InstructorDetail("youtube342.com", "Football");
            Instructor tempInstructor = new Instructor("Ajay", "Patil", "loo@bar.com", tempInstructorDetail);
            
            curSession.beginTransaction();

            curSession.save(tempInstructor);
            System.out.println(tempInstructor);
            System.out.println(tempInstructorDetail);
            System.out.println("\n\n\n");

            curSession.getTransaction().commit();
        }finally{
            factory.close();
        }
	}

}
