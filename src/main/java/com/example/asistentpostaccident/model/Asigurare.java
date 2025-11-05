package com.example.asistentpostaccident.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Participant participant;

    // Asigurare getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCompanieRCA() { return companieRCA; }
    public void setCompanieRCA(String companieRCA) { this.companieRCA = companieRCA; }

    public String getNumarPolita() { return numarPolita; }
    public void setNumarPolita(String numarPolita) { this.numarPolita = numarPolita; }

    public Participant getParticipant() { return participant; }
    public void setParticipant(Participant participant) {
        this.participant = participant;
        if (participant != null && participant.getAsigurare() != this) {
            participant.setAsigurare(this);
        }
    }
}
