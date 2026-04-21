package com.example.demo.service;

import com.example.demo.dto.ProgrammeDTO;
import com.example.demo.model.Programme;
import com.example.demo.repository.ProgrammeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Updated ProgrammeService that returns DTOs
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProgrammeService {
    private final ProgrammeRepository programmeRepository;

    public List<ProgrammeDTO> getAllProgrammes() {
        return ProgrammeDTO.fromEntities(programmeRepository.findAll());
    }

    public ProgrammeDTO getProgrammeById(String id) {
        Programme programme = programmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programme not found with id: " + id));
        return ProgrammeDTO.fromEntity(programme);
    }

    @Transactional
    public ProgrammeDTO createProgramme(ProgrammeDTO programmeDTO) {
        Programme programme = convertToEntity(programmeDTO);
        if (programme.getId() == null) {
            programme.setId(java.util.UUID.randomUUID().toString());
        }
        Programme saved = programmeRepository.save(programme);
        return ProgrammeDTO.fromEntity(saved);
    }

    @Transactional
    public ProgrammeDTO updateProgramme(String id, ProgrammeDTO programmeDetailsDTO) {
        Programme programme = getProgrammeEntityById(id);
        updateProgrammeEntity(programme, programmeDetailsDTO);
        Programme updated = programmeRepository.save(programme);
        return ProgrammeDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteProgramme(String id) {
        programmeRepository.deleteById(id);
    }
    
    // Helper methods for internal use
    private Programme getProgrammeEntityById(String id) {
        return programmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programme not found with id: " + id));
    }
    
    private Programme convertToEntity(ProgrammeDTO dto) {
        Programme programme = new Programme();
        programme.setId(dto.getId());
        programme.setName(dto.getName());
        programme.setShortName(dto.getShortName());
        programme.setTotalEcts(dto.getTotalEcts());
        programme.setStandardSems(dto.getStandardSems());
        programme.setValidFrom(dto.getValidFrom());
        programme.setThesisEcts(dto.getThesisEcts());
        programme.setThesisMinEcts(dto.getThesisMinEcts());
        programme.setMinEctsPerYear(dto.getMinEctsPerYear());
        
        // Set Degree if degree is provided
        if (dto.getDegree() != null) {
            programme.setDegree(Programme.Degree.valueOf(dto.getDegree()));
        }
        
        return programme;
    }
    
    private void updateProgrammeEntity(Programme programme, ProgrammeDTO dto) {
        programme.setName(dto.getName());
        programme.setShortName(dto.getShortName());
        programme.setTotalEcts(dto.getTotalEcts());
        programme.setStandardSems(dto.getStandardSems());
        programme.setValidFrom(dto.getValidFrom());
        programme.setThesisEcts(dto.getThesisEcts());
        programme.setThesisMinEcts(dto.getThesisMinEcts());
        programme.setMinEctsPerYear(dto.getMinEctsPerYear());

        // Update Degree if degree is provided
        if (dto.getDegree() != null) {
            programme.setDegree(Programme.Degree.valueOf(dto.getDegree()));
        }
    }
}
