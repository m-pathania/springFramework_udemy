package com.hibernate_basics.one2many;

import java.util.ArrayList;

import com.hibernate_basics.one2many.course.Course;
import com.hibernate_basics.one2many.course.Review;
import com.hibernate_basics.one2many.instructor.Instructor;
import com.hibernate_basics.one2many.instructor.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddReviews {
    public static void main(String [] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetail.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .addAnnotatedClass(Review.class)
                                                    .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Course course1 = session.get(Course.class, 10);
            Course course2 = session.get(Course.class, 11);
            Review review1 = new Review("Great course to get started with FEM.");
            Review review2 = new Review("Application part of the course is really amazing.");
            ArrayList<Review> reviews = new ArrayList<>();
            reviews.add(new Review("Fundamentals are cleared Effectively."));
            reviews.add(new Review("Good understanding to the Continuum mechanics."));

            course1.addReview(review1);
            course1.addReview(review2);
            course2.setReviews(reviews);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

            System.out.println("\n\n\n\n");
            System.out.println(course1);
            System.out.println(course2);
            System.out.println("\n\n\n\n");
        }finally{
            factory.close();
        }
    }
}
