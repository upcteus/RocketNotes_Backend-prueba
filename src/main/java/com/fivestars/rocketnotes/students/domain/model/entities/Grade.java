package com.fivestars.rocketnotes.students.domain.model.entities;

import jakarta.persistence.*;


@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String course;
    private Double score;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // getters and setters
}