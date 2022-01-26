package com.hibernate_basics.one2many;

import com.hibernate_basics.one2many.course.Course;
import com.hibernate_basics.one2many.course.Review;
import com.hibernate_basics.one2many.instructor.Instructor;
import com.hibernate_basics.one2many.instructor.InstructorDetail;
import com.hibernate_basics.one2many.student.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddInstructors {
    public static void main(String [] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetail.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .addAnnotatedClass(Review.class)
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();

        try{

            Instructor inst1 = new Instructor("Ramesh", "Suresh", "ramesh@gmail.com");
            InstructorDetail instDetail1 = new InstructorDetail("RameshRock", "Jap");
            inst1.setInstructorDetail(instDetail1);
            save(factory, inst1);

            Instructor inst2 = new Instructor("Rakesh", "Raja", "rakesh@gmail.com");
            InstructorDetail instDetail2 = new InstructorDetail("Roster", "Tap");
            inst2.setInstructorDetail(instDetail2);
            save(factory, inst2);

            Instructor inst3 = new Instructor("Hardik", "Pandu", "pandu@gmail.com");
            InstructorDetail instDetail3 = new InstructorDetail("JohnCena", "Crap");
            inst3.setInstructorDetail(instDetail3);
            save(factory, inst3);

            Instructor inst4 = new Instructor("Pappu", "Pushpa", "pp@yahoo.com");
            InstructorDetail instDetail4 = new InstructorDetail("Jockero", "Nap");
            inst4.setInstructorDetail(instDetail4);
            save(factory, inst4);

        }finally{
            factory.close();
        }
    }

    public static void save(SessionFactory factory, Instructor instructor){
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.save(instructor);
        System.out.println("\n\n\n" + instructor + "\n\n\n");

        session.getTransaction().commit();
    }
}
