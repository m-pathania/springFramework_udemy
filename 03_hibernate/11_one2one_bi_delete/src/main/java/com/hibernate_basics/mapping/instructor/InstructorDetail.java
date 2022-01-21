package com.hibernate_basics.mapping.instructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="youtube_channel")
    private String youtube;

    @Column(name="hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", cascade={CascadeType.DETACH, CascadeType.MERGE,
                                                    CascadeType.PERSIST, CascadeType.REFRESH,
                                                    CascadeType.REMOVE})
    private Instructor instructor;

    public InstructorDetail() {
    }

    public InstructorDetail(String youtube, String hobby) {
        this.youtube = youtube;
        this.hobby = hobby;
    }

    public InstructorDetail(String youtube, String hobby, Instructor instructor) {
        this.youtube = youtube;
        this.hobby = hobby;
        this.instructor = instructor;
        this.instructor.setInstructorDetail(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor(){
        return this.instructor;
    }

    public void setInstructor(Instructor instructor){
        this.instructor = instructor;
        this.instructor.setInstructorDetail(this);
    }

    @Override
    public String toString() {
        return "InstructorDetail [ id=" + id + "hobby=" + hobby +  ", youtube=" + youtube + "]";
    }
    
}
