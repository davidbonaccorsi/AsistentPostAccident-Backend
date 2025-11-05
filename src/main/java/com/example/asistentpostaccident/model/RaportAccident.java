package com.example.asistentpostaccident.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "rapoarte_accident")
public class RaportAccident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataAccidentului;
    private String locatieAdresa;
    private Double latitudine;
    private Double longitudine;
    private String descriere;

    @OneToMany(mappedBy = "raport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participant> participanti;

    @OneToMany(mappedBy = "raport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fotografie> fotografii;

    @OneToMany(mappedBy = "raport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documente;

    @OneToOne(mappedBy = "raport", cascade = CascadeType.ALL)
    private ConstatareAmiabila constatareAmiabila;

    // Getters and Setters
}
