package com.hibernate_basics.mapping;

import org.hibernate.SessionFactory;

import com.hibernate_basics.mapping.instructor.Instructor;
import com.hibernate_basics.mapping.instructor.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetail {
    public static void main(String[] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            InstructorDetail addInstDetail = new InstructorDetail("youtubeURL.com", "MOTTO");
            Instructor addInst = new Instructor("Rama", "Nuja", "foobarEmail@mail.com");
            addInst.setInstructorDetail(addInstDetail);
            session.save(addInst);
            session.getTransaction().commit();
            System.out.println(addInst+"\n\n\n\n");
            
            session = factory.getCurrentSession();
            session.beginTransaction();

            InstructorDetail tempInstDetail = session.get(InstructorDetail.class, 5);
            System.out.println(tempInstDetail+"\n\n\n");

            session.delete(tempInstDetail);

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            tempInstDetail = session.get(InstructorDetail.class, 6);
            System.out.println(tempInstDetail+"\n\n\n");
            tempInstDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstDetail);
            session.getTransaction().commit();
        }finally{
            factory.close();
        }
    }
}
