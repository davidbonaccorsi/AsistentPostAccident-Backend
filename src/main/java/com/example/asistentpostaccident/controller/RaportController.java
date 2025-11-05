package com.example.asistentpostaccident.controller;

import com.example.asistentpostaccident.model.RaportAccident;
import com.example.asistentpostaccident.service.RaportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rapoarte")
public class RaportController {

    private final RaportService raportService;

    public RaportController(RaportService raportService) {
        this.raportService = raportService;
    }

    @GetMapping
    public List<RaportAccident> getAll() {
        return raportService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RaportAccident> getById(@PathVariable Long id) {
        return raportService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RaportAccident> create(@RequestBody RaportAccident raport) {
        RaportAccident saved = raportService.save(raport);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RaportAccident> update(@PathVariable Long id, @RequestBody RaportAccident raport) {
        return raportService.getById(id)
                .map(existing -> {
                    raport.setId(existing.getId());
                    return ResponseEntity.ok(raportService.save(raport));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        raportService.delete(id);
        return ResponseEntity.noContent().build();
    }
}