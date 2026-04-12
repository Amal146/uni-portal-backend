package com.example.demo.service;

import com.example.demo.model.ThesisPrerequisite;
import com.example.demo.repository.ThesisPrerequisiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ThesisPrerequisiteService {
    private final ThesisPrerequisiteRepository thesisPrerequisiteRepository;

    public List<ThesisPrerequisite> getAllThesisPrerequisites() {
        return thesisPrerequisiteRepository.findAll();
    }

    public ThesisPrerequisite getThesisPrerequisiteById(String id) {
        return thesisPrerequisiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ThesisPrerequisite not found with id: " + id));
    }

    @Transactional
    public ThesisPrerequisite createThesisPrerequisite(ThesisPrerequisite prerequisite) {
        if (prerequisite.getId() == null) {
            prerequisite.setId(UUID.randomUUID().toString());
        }
        return thesisPrerequisiteRepository.save(prerequisite);
    }

    @Transactional
    public ThesisPrerequisite updateThesisPrerequisite(String id, ThesisPrerequisite prerequisiteDetails) {
        ThesisPrerequisite prerequisite = getThesisPrerequisiteById(id);
        prerequisite.setProgramme(prerequisiteDetails.getProgramme());
        prerequisite.setModule(prerequisiteDetails.getModule());
        return thesisPrerequisiteRepository.save(prerequisite);
    }

    @Transactional
    public void deleteThesisPrerequisite(String id) {
        thesisPrerequisiteRepository.deleteById(id);
    }

    public List<ThesisPrerequisite> getPrerequisitesByProgrammeId(String programmeId) {
        return thesisPrerequisiteRepository.findByProgrammeId(programmeId);
    }

    public List<ThesisPrerequisite> getPrerequisitesByModuleId(String moduleId) {
        return thesisPrerequisiteRepository.findByModuleId(moduleId);
    }
}