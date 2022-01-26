package com.hibernate_basics.one2many;

import com.hibernate_basics.one2many.course.Course;
import com.hibernate_basics.one2many.course.Review;
import com.hibernate_basics.one2many.instructor.Instructor;
import com.hibernate_basics.one2many.instructor.InstructorDetail;
import com.hibernate_basics.one2many.student.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
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

            Course course1 = session.get(Course.class, 11);
            Student student1 = session.get(Student.class, 1);
            System.out.println("\n\n\n" + course1.getTitle());
            System.out.println(student1);
            System.out.println(course1.getStudents());
            System.out.println(student1.getCourses());
            System.out.println("\n\n\n");

            session.delete(course1);
            session.delete(student1);

            session.getTransaction().commit();
        }finally{
            factory.close();
        }
    }
    
}
