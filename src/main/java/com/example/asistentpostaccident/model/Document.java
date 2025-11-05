package com.example.asistentpostaccident.model;

import jakarta.persistence.*;

@Entity
@Table(name = "documente")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tip;
    private String caleFisier;

    @ManyToOne
    @JoinColumn(name = "raport_id")
    private RaportAccident raport;

    // Getters and Setters
}
