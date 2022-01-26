package com.hibernate_basics.one2many.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hibernate_basics.one2many.instructor.Instructor;

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="theory")
    private int theory;

    @Column(name="practical")
    private int practical;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    private Instructor instructor;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="course_id")
    private List<Review> reviews;

    public Course() {
    }

    public Course(String title, int theory, int practical) {
        this.title = title;
        this.theory = theory;
        this.practical = practical;
    }

    public Course(String title, int theory, int practical, Instructor instructor) {
        this.title = title;
        this.theory = theory;
        this.practical = practical;
        this.instructor = instructor;
        this.instructor.addCourse(this);
    }

    public Course(String title, int theory, int practical, Instructor instructor, List<Review> reviews) {
        this.title = title;
        this.theory = theory;
        this.practical = practical;
        this.instructor = instructor;
        this.instructor.addCourse(this);
        this.reviews = reviews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTheory() {
        return theory;
    }

    public void setTheory(int theory) {
        this.theory = theory;
    }

    public int getPractical() {
        return practical;
    }

    public void setPractical(int practical) {
        this.practical = practical;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review){
        if(this.reviews == null){
            this.reviews = new ArrayList<>();
        }
        this.reviews.add(review);
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", practical=" + practical + ", reviews=" + reviews + ", theory=" + theory
                + ", title=" + title + "]";
    }
    
}
