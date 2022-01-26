package com.hibernate_basics.one2many.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hibernate_basics.one2many.instructor.Instructor;
import com.hibernate_basics.one2many.student.Student;

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

    @ManyToMany(fetch=FetchType.LAZY,
                cascade={CascadeType.DETACH, CascadeType.MERGE,
                        CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="course_student",
                joinColumns=@JoinColumn(name="course_id"),
                inverseJoinColumns=@JoinColumn(name="student_id"))
    private List<Student> students;

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
        this.reviews = reviews;
        this.instructor.addCourse(this);
    }

    public Course(String title, int theory, int practical, Instructor instructor, List<Review> reviews,
            List<Student> students) {
        this.title = title;
        this.theory = theory;
        this.practical = practical;
        this.instructor = instructor;
        this.reviews = reviews;
        this.students = students;
        this.instructor.addCourse(this);
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        if(this.students == null){
            this.students = new ArrayList<>();
        }
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", practical=" + practical + ", reviews=" + reviews + ", theory=" + theory
                + ", title=" + title + "]";
    }
    
}
