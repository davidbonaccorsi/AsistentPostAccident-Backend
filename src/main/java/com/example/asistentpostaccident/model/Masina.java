package com.example.asistentpostaccident.model;

import jakarta.persistence.*;

@Entity
@Table(name = "masini")
public class Masina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numarInmatriculare;
    private String marca;
    private String model;
    private Integer anFabricatie;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    // Getters and Setters
}
