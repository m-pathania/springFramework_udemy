package com.hibernate_basics.one2many;

import java.util.ArrayList;

import com.hibernate_basics.one2many.course.Course;
import com.hibernate_basics.one2many.course.Review;
import com.hibernate_basics.one2many.instructor.Instructor;
import com.hibernate_basics.one2many.instructor.InstructorDetail;
import com.hibernate_basics.one2many.student.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CombineCourseStudent {
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

            Student student1 = session.get(Student.class, 1);
            Student student2 = session.get(Student.class, 2);
            Student student3 = session.get(Student.class, 3);
            Student student4 = session.get(Student.class, 4);
            Student student5 = session.get(Student.class, 5);
            Student student6 = session.get(Student.class, 6);

            Course course1 = session.get(Course.class, 10);
            Course course2 = session.get(Course.class, 11);
            Course course3 = session.get(Course.class, 12);

            ArrayList<Student> students = new ArrayList<>();
            students.add(student1);
            students.add(student2);
            students.add(student3);
            students.add(student4);
            course1.setStudents(students);
            course1.addStudent(student6);

            course2.addStudent(student1);
            course2.addStudent(student3);
            course2.addStudent(student5);
            course2.addStudent(student2);

            student6.addCourse(course2);
            student6.addCourse(course3);

            session.getTransaction().commit();
        }finally{
            factory.close();
        }
    }
}
