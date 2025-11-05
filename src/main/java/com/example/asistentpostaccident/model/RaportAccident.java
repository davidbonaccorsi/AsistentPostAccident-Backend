package com.example.asistentpostaccident.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private List<Participant> participanti;

    @OneToMany(mappedBy = "raport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fotografie> fotografii;

    @OneToMany(mappedBy = "raport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documente;

    @OneToOne(mappedBy = "raport", cascade = CascadeType.ALL)
    private ConstatareAmiabila constatareAmiabila;

    // === Getters and Setters ===

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAccidentului() {
        return dataAccidentului;
    }

    public void setDataAccidentului(LocalDateTime dataAccidentului) {
        this.dataAccidentului = dataAccidentului;
    }

    public String getLocatieAdresa() {
        return locatieAdresa;
    }

    public void setLocatieAdresa(String locatieAdresa) {
        this.locatieAdresa = locatieAdresa;
    }

    public Double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(Double latitudine) {
        this.latitudine = latitudine;
    }

    public Double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(Double longitudine) {
        this.longitudine = longitudine;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public List<Participant> getParticipanti() {
        return participanti;
    }

    public void setParticipanti(List<Participant> participanti) {
        this.participanti = participanti;
    }

    public List<Fotografie> getFotografii() {
        return fotografii;
    }

    public void setFotografii(List<Fotografie> fotografii) {
        this.fotografii = fotografii;
    }

    public List<Document> getDocumente() {
        return documente;
    }

    public void setDocumente(List<Document> documente) {
        this.documente = documente;
    }

    public ConstatareAmiabila getConstatareAmiabila() {
        return constatareAmiabila;
    }

    public void setConstatareAmiabila(ConstatareAmiabila constatareAmiabila) {
        this.constatareAmiabila = constatareAmiabila;
    }
}
