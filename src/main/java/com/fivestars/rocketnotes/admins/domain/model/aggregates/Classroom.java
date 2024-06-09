package com.fivestars.rocketnotes.admins.domain.model.aggregates;

import com.fivestars.rocketnotes.admins.domain.model.entities.Course;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String section;
    private int capacity;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Course> courses = new HashSet<>();

    // Getters and Setters
}
