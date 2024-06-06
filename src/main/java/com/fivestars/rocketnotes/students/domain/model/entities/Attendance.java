package com.fivestars.rocketnotes.students.domain.model.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // getters and setters
}