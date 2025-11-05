package com.example.asistentpostaccident.service;

import com.example.asistentpostaccident.model.RaportAccident;
import com.example.asistentpostaccident.repository.RaportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaportService {

    private final RaportRepository raportRepository;

    public RaportService(RaportRepository raportRepository) {
        this.raportRepository = raportRepository;
    }

    public List<RaportAccident> getAll() {
        return raportRepository.findAll();
    }

    public Optional<RaportAccident> getById(Long id) {
        return raportRepository.findById(id);
    }

    public RaportAccident save(RaportAccident raport) {
        return raportRepository.save(raport);
    }

    public void delete(Long id) {
        raportRepository.deleteById(id);
    }
}
