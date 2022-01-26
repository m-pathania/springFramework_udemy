package com.hibernate_basics.one2many;

import com.hibernate_basics.one2many.course.Course;
import com.hibernate_basics.one2many.course.Review;
import com.hibernate_basics.one2many.instructor.Instructor;
import com.hibernate_basics.one2many.instructor.InstructorDetail;
import com.hibernate_basics.one2many.student.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddStudent{
    public static void main(String [] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetail.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .addAnnotatedClass(Review.class)
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Student student1 = new Student("John", "Michael", "john@email.com");
            Student student2 = new Student("Peter", "Parker", "peter@email.com");
            Student student3 = new Student("Rohan", "Michael", "rohan.michael@email.com");
            Student student4 = new Student("Dracula", "Khoon", "drakula.khoon@email.com");
            Student student5 = new Student("Meg", "Griffin", "griffin.meg@email.com");
            Student student6 = new Student("Stewie", "Retro", "stewie.science@email.com");

            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.save(student4);
            session.save(student5);
            session.save(student6);

            session.getTransaction().commit();
        }finally{
            factory.close();
        }
    }
}