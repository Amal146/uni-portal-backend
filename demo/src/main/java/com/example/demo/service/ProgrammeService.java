package com.example.demo.service;

import com.example.demo.model.Programme;
import com.example.demo.repository.ProgrammeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProgrammeService {
    private final ProgrammeRepository programmeRepository;

    public List<Programme> getAllProgrammes() {
        return programmeRepository.findAll();
    }

    public Programme getProgrammeById(String id) {
        return programmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programme not found with id: " + id));
    }

    @Transactional
    public Programme createProgramme(Programme programme) {
        if (programme.getId() == null) {
            programme.setId(UUID.randomUUID().toString());
        }
        return programmeRepository.save(programme);
    }

    @Transactional
    public Programme updateProgramme(String id, Programme programmeDetails) {
        Programme programme = getProgrammeById(id);
        programme.setName(programmeDetails.getName());
        programme.setShortName(programmeDetails.getShortName());
        programme.setDegree(programmeDetails.getDegree());
        programme.setTotalEcts(programmeDetails.getTotalEcts());
        programme.setStandardSems(programmeDetails.getStandardSems());
        programme.setValidFrom(programmeDetails.getValidFrom());
        programme.setThesisEcts(programmeDetails.getThesisEcts());
        programme.setThesisMinEcts(programmeDetails.getThesisMinEcts());
        return programmeRepository.save(programme);
    }

    @Transactional
    public void deleteProgramme(String id) {
        programmeRepository.deleteById(id);
    }
}
