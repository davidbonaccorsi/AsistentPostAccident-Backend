package com.example.asistentpostaccident.model;

import jakarta.persistence.*;

@Entity
@Table(name = "participanti")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RolParticipant rol;

    private String numeComplet;
    private String telefon;
    private String email;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private Masina masina;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private Asigurare asigurare;

    @ManyToOne
    @JoinColumn(name = "raport_id")
    private RaportAccident raport;

    // Getters and Setters
}
