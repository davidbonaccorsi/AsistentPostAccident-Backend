package com.example.asistentpostaccident.model;

import jakarta.persistence.*;

@Entity
@Table(name = "constatari_amiabile")
public class ConstatareAmiabila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String circumstanteVehiculA;
    private String circumstanteVehiculB;

    @OneToOne
    @JoinColumn(name = "raport_id")
    private RaportAccident raport;

    // Getters and Setters
}
