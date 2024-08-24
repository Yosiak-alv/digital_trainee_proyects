package com.digital.spring_relationships.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  String lastname;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "course_id"})
    )
    private Set<Course> courses;

    public Student() {
        this.courses = new HashSet<>();
    }

    public Student(String name, String lastname) {
        this();
        this.name = name;
        this.lastname = lastname;
    }

    public Student addCourse(Course course){
        this.courses.add(course);
        course.getStudents().add(this);
        return this;
    }

    public void removeCourse(Course course){
        this.getCourses().removeIf(course1 -> course1.getId().equals(course.getId()));
    }
}
