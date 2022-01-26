package com.hibernate_basics.one2many;

import com.hibernate_basics.one2many.course.Course;
import com.hibernate_basics.one2many.course.Review;
import com.hibernate_basics.one2many.instructor.Instructor;
import com.hibernate_basics.one2many.instructor.InstructorDetail;
import com.hibernate_basics.one2many.student.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourses {
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

            Course course1 = new Course("FEM", 70, 30);
            Instructor inst1 = session.get(Instructor.class, 1);
            inst1.addCourse(course1);
            save(session, course1);

            Course course2 = new Course("Continuum Mechanics", 90, 10);
            inst1.addCourse(course2);
            save(session, course2);

            Instructor inst2 = session.get(Instructor.class, 2);
            Course course3 = new Course("ADMOS", 100, 0);
            course3.setInstructor(inst2);
            save(session, course3);

            Course course4 = new Course("Maths", 30, 70);
            course4.setInstructor(inst2);
            save(session, course4);

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
