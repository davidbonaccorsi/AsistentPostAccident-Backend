package com.example.asistentpostaccident.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asigurari")
public class Asigurare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companieRCA;
    private String numarPolita;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    // Getters and Setters
}
