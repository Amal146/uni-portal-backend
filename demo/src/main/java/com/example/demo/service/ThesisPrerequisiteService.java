package com.example.demo.service;

import com.example.demo.model.ThesisPrerequisite;
import com.example.demo.repository.ThesisPrerequisiteRepository;
import com.example.demo.repository.ProgrammeRepository;
import com.example.demo.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ThesisPrerequisiteService {
    
    @Autowired
    private ThesisPrerequisiteRepository thesisPrerequisiteRepository;
    
    @Autowired
    private ProgrammeRepository programmeRepository;
    
    @Autowired
    private ModuleRepository moduleRepository;
    
    public List<ThesisPrerequisite> getPrerequisitesByProgramme(String programmeId) {
        return thesisPrerequisiteRepository.findByProgrammeId(programmeId);
    }
    
    public List<ThesisPrerequisite> getPrerequisitesByModule(String moduleId) {
        return thesisPrerequisiteRepository.findByModuleId(moduleId);
    }
    
    @Transactional
    public ThesisPrerequisite createPrerequisite(ThesisPrerequisite prerequisite) {
        programmeRepository.findById(prerequisite.getProgramme().getId())
            .orElseThrow(() -> new RuntimeException("Programme not found"));
        moduleRepository.findById(prerequisite.getModule().getId())
            .orElseThrow(() -> new RuntimeException("Module not found"));
        return thesisPrerequisiteRepository.save(prerequisite);
    }
    
    @Transactional
    public void deletePrerequisite(String id) {
        thesisPrerequisiteRepository.deleteById(id);
    }
}