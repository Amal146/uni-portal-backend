package com.example.demo.service;

import com.example.demo.dto.ThesisPrerequisiteDTO;
import com.example.demo.model.ThesisPrerequisite;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.repository.ProgrammeRepository;
import com.example.demo.model.Module;
import com.example.demo.model.Programme;
import com.example.demo.repository.ThesisPrerequisiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Updated ThesisPrerequisiteService that returns DTOs
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ThesisPrerequisiteService {
    private final ThesisPrerequisiteRepository thesisPrerequisiteRepository;
    private final ProgrammeRepository programmeRepository;
    private final ModuleRepository moduleRepository;

    public List<ThesisPrerequisiteDTO> getAllThesisPrerequisites() {
        return ThesisPrerequisiteDTO.fromEntities(thesisPrerequisiteRepository.findAll());
    }

    public ThesisPrerequisiteDTO getThesisPrerequisiteById(String id) {
        ThesisPrerequisite prerequisite = thesisPrerequisiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ThesisPrerequisite not found with id: " + id));
        return ThesisPrerequisiteDTO.fromEntity(prerequisite);
    }

    @Transactional
    public ThesisPrerequisiteDTO createThesisPrerequisite(ThesisPrerequisiteDTO prerequisiteDTO) {
        ThesisPrerequisite prerequisite = convertToEntity(prerequisiteDTO);
        if (prerequisite.getId() == null) {
            prerequisite.setId(java.util.UUID.randomUUID().toString());
        }
        ThesisPrerequisite saved = thesisPrerequisiteRepository.save(prerequisite);
        return ThesisPrerequisiteDTO.fromEntity(saved);
    }

    @Transactional
    public ThesisPrerequisiteDTO updateThesisPrerequisite(String id, ThesisPrerequisiteDTO prerequisiteDetailsDTO) {
        ThesisPrerequisite prerequisite = getThesisPrerequisiteEntityById(id);
        updateThesisPrerequisiteEntity(prerequisite, prerequisiteDetailsDTO);
        ThesisPrerequisite updated = thesisPrerequisiteRepository.save(prerequisite);
        return ThesisPrerequisiteDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteThesisPrerequisite(String id) {
        thesisPrerequisiteRepository.deleteById(id);
    }

    public List<ThesisPrerequisiteDTO> getPrerequisitesByProgrammeId(String programmeId) {
        return ThesisPrerequisiteDTO.fromEntities(thesisPrerequisiteRepository.findByProgrammeId(programmeId));
    }

    public List<ThesisPrerequisiteDTO> getPrerequisitesByModuleId(String moduleId) {
        return ThesisPrerequisiteDTO.fromEntities(thesisPrerequisiteRepository.findByModuleId(moduleId));
    }
    
    // Helper methods for internal use
    private ThesisPrerequisite getThesisPrerequisiteEntityById(String id) {
        return thesisPrerequisiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ThesisPrerequisite not found with id: " + id));
    }
    
    private ThesisPrerequisite convertToEntity(ThesisPrerequisiteDTO dto) {
        ThesisPrerequisite prerequisite = new ThesisPrerequisite();
        prerequisite.setId(dto.getId());
        
        // Set Programme if programmeId is provided
        if (dto.getProgrammeId() != null) {
            Programme programme = programmeRepository.findById(dto.getProgrammeId())
                    .orElseThrow(() -> new RuntimeException("Programme not found with id: " + dto.getProgrammeId()));
            prerequisite.setProgramme(programme);
        }
        
        // Set Module if moduleId is provided
        if (dto.getModuleId() != null) {
            Module module = moduleRepository.findById(dto.getModuleId())
                    .orElseThrow(() -> new RuntimeException("Module not found with id: " + dto.getModuleId()));
            prerequisite.setModule(module);
        }
        
        return prerequisite;
    }
    
    private void updateThesisPrerequisiteEntity(ThesisPrerequisite prerequisite, ThesisPrerequisiteDTO dto) {
        // Update Programme if programmeId is provided
        if (dto.getProgrammeId() != null) {
            Programme programme = programmeRepository.findById(dto.getProgrammeId())
                    .orElseThrow(() -> new RuntimeException("Programme not found with id: " + dto.getProgrammeId()));
            prerequisite.setProgramme(programme);
        }
        
        // Update Module if moduleId is provided
        if (dto.getModuleId() != null) {
            Module module = moduleRepository.findById(dto.getModuleId())
                    .orElseThrow(() -> new RuntimeException("Module not found with id: " + dto.getModuleId()));
            prerequisite.setModule(module);
        }
    }
}
