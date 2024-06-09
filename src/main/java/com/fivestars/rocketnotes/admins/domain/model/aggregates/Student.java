package com.fivestars.rocketnotes.admins.domain.model.aggregates;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String paternalLastName;
    private String maternalLastName;
    private String dni;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

}
