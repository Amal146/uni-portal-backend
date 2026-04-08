package com.example.demo.service;

import com.example.demo.model.Programme;
import com.example.demo.repository.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProgrammeService {
    
    @Autowired
    private ProgrammeRepository programmeRepository;
    
    public List<Programme> getAllProgrammes() {
        return programmeRepository.findAll();
    }
    
    public Optional<Programme> getProgrammeById(String id) {
        return programmeRepository.findById(id);
    }
    
    public Programme createProgramme(Programme programme) {
        return programmeRepository.save(programme);
    }
    
    public Programme updateProgramme(String id, Programme programmeDetails) {
        Programme programme = programmeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Programme not found"));
        
        programme.setName(programmeDetails.getName());
        programme.setDegree(programmeDetails.getDegree());
        programme.setFaculty(programmeDetails.getFaculty());
        programme.setMinEctsPerYear(programmeDetails.getMinEctsPerYear());
        
        return programmeRepository.save(programme);
    }
    
    public void deleteProgramme(String id) {
        programmeRepository.deleteById(id);
    }
}
