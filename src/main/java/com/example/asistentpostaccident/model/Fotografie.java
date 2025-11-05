package com.example.asistentpostaccident.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fotografii")
public class Fotografie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categorie;
    private String caleFisier; // file path

    @ManyToOne
    @JoinColumn(name = "raport_id")
    private RaportAccident raport;

    // Getters and Setters
}
