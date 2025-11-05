package com.example.asistentpostaccident.repository;

import com.example.asistentpostaccident.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findByRaportId(Long raportId);
}
