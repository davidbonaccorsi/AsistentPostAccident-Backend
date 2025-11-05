package com.example.asistentpostaccident.service;

import com.example.asistentpostaccident.model.*;
import com.example.asistentpostaccident.repository.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final MasinaRepository masinaRepository;
    private final AsigurareRepository asigurareRepository;

    public ParticipantService(ParticipantRepository participantRepository,
                              MasinaRepository masinaRepository,
                              AsigurareRepository asigurareRepository) {
        this.participantRepository = participantRepository;
        this.masinaRepository = masinaRepository;
        this.asigurareRepository = asigurareRepository;
    }

    public Optional<Participant> getById(Long id) {
        return participantRepository.findById(id);
    }

    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }

    public Masina addMasina(Long participantId, Masina masina) {
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new RuntimeException("Participant not found"));

        masina.setParticipant(participant);
        participant.setMasina(masina);
        masinaRepository.save(masina);
        participantRepository.save(participant);
        return masina;
    }

    public Asigurare addAsigurare(Long participantId, Asigurare asigurare) {
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new RuntimeException("Participant not found"));

        asigurare.setParticipant(participant);
        participant.setAsigurare(asigurare);
        asigurareRepository.save(asigurare);
        participantRepository.save(participant);
        return asigurare;
    }
}
