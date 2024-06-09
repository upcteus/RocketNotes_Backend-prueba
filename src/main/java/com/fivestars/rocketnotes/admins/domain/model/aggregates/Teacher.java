package com.fivestars.rocketnotes.admins.domain.model.aggregates;

import jakarta.persistence.*;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String paternalLastName;
    private String dni;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    // Getters and Setters
}