package com.example.asistentpostaccident.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Participant participant;

    // Masina getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumarInmatriculare() { return numarInmatriculare; }
    public void setNumarInmatriculare(String numarInmatriculare) { this.numarInmatriculare = numarInmatriculare; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getAnFabricatie() { return anFabricatie; }
    public void setAnFabricatie(Integer anFabricatie) { this.anFabricatie = anFabricatie; }

    public Participant getParticipant() { return participant; }
    public void setParticipant(Participant participant) {
        this.participant = participant;
        if (participant != null && participant.getMasina() != this) {
            participant.setMasina(this);
        }
    }
}
