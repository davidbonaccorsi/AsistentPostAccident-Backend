package com.example.asistentpostaccident.controller;

import com.example.asistentpostaccident.model.*;
import com.example.asistentpostaccident.service.ParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/participanti")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("/{id}/masina")
    public ResponseEntity<Masina> adaugaMasina(@PathVariable Long id, @RequestBody Masina masina) {
        Masina saved = participantService.addMasina(id, masina);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{id}/asigurare")
    public ResponseEntity<Asigurare> adaugaAsigurare(@PathVariable Long id, @RequestBody Asigurare asigurare) {
        Asigurare saved = participantService.addAsigurare(id, asigurare);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participant> getById(@PathVariable Long id) {
        return participantService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
