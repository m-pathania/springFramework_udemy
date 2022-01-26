package com.hibernate_basics.one2many.course;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @Override
    public String toString() {
        return "Course [id=" + id + ", practical=" + practical + ", theory=" + theory + ", title=" + title + "]";
    }

}
