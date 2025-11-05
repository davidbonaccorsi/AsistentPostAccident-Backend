package com.example.asistentpostaccident.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private Masina masina;
    // A participant has a car and each car belongs to a participant

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Asigurare asigurare;
    // A participant has a insurance and each insurance belongs to a participant. WE USE THE LEGAL INSTANCE BC JAIL SUCKS :)

    @ManyToOne
    @JoinColumn(name = "raport_id")
    @JsonBackReference
    private RaportAccident raport;


    // === Participant getters & setters ===

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolParticipant getRol() {
        return rol;
    }

    public void setRol(RolParticipant rol) {
        this.rol = rol;
    }

    public String getNumeComplet() {
        return numeComplet;
    }

    public void setNumeComplet(String numeComplet) {
        this.numeComplet = numeComplet;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Masina getMasina() {
        return masina;
    }

    public void setMasina(Masina masina) {
        this.masina = masina;
        if (masina != null && masina.getParticipant() != this) {
            masina.setParticipant(this);
        }
    }

    public Asigurare getAsigurare() {
        return asigurare;
    }

    public void setAsigurare(Asigurare asigurare) {
        this.asigurare = asigurare;
        if (asigurare != null && asigurare.getParticipant() != this) {
            asigurare.setParticipant(this);
        }
    }

    public RaportAccident getRaport() {
        return raport;
    }

    public void setRaport(RaportAccident raport) {
        this.raport = raport;
    }

}
