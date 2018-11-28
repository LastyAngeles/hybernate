package com.education.geek.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String title;

    @ManyToMany
    @JoinTable(
            name = "study_list",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_course")
    )
    private List<Student> studList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudList() {
        return studList;
    }

    public void setStudList(List<Student> studList) {
        this.studList = studList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Student student : studList){
            builder.append(student.getName() + " ");
        }
        return "Course " + title + " : " + " with ID " + id + " now have students like - " + builder.toString();
    }
}
