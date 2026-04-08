package com.example.demo.service;


import com.example.demo.model.Module;
import com.example.demo.model.Module.ModuleType;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.repository.ProgrammeRepository;
import com.example.demo.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {
    
    @Autowired
    private ModuleRepository moduleRepository;
    
    @Autowired
    private ProgrammeRepository programmeRepository;
    
    @Autowired
    private LecturerRepository lecturerRepository;
    
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }
    
    public Optional<Module> getModuleById(String id) {
        return moduleRepository.findById(id);
    }
    
    public List<Module> getModulesByProgramme(String programmeId) {
        return moduleRepository.findByProgrammeId(programmeId);
    }
    
    public List<Module> getModulesByCoordinator(String lecturerId) {
        return moduleRepository.findByModuleCoordinatorId(lecturerId);
    }
    
    public List<Module> getModulesByType(ModuleType type) {
        return moduleRepository.findByType(type);
    }
    
    @Transactional
    public Module createModule(Module module) {
        // Validate programme exists
        if (module.getProgramme() != null && module.getProgramme().getId() != null) {
            programmeRepository.findById(module.getProgramme().getId())
                .orElseThrow(() -> new RuntimeException("Programme not found"));
        }
        
        // Validate coordinator exists
        if (module.getModuleCoordinator() != null && module.getModuleCoordinator().getId() != null) {
            lecturerRepository.findById(module.getModuleCoordinator().getId())
                .orElseThrow(() -> new RuntimeException("Lecturer not found"));
        }
        
        // Check for duplicate module code
        if (module.getModuleCode() != null) {
            Optional<Module> existingModule = moduleRepository.findByModuleCode(module.getModuleCode());
            if (existingModule.isPresent()) {
                throw new RuntimeException("Module code already exists");
            }
        }
        
        return moduleRepository.save(module);
    }
    
    @Transactional
    public Module updateModule(String id, Module moduleDetails) {
        Module module = moduleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
        
        if (moduleDetails.getModuleCode() != null) {
            // Check for duplicate module code (excluding current module)
            Optional<Module> existingModule = moduleRepository.findByModuleCode(moduleDetails.getModuleCode());
            if (existingModule.isPresent() && !existingModule.get().getId().equals(id)) {
                throw new RuntimeException("Module code already exists");
            }
            module.setModuleCode(moduleDetails.getModuleCode());
        }
        
        if (moduleDetails.getName() != null) {
            module.setName(moduleDetails.getName());
        }
        
        if (moduleDetails.getEcts() != null) {
            if (moduleDetails.getEcts() <= 0) {
                throw new RuntimeException("ECTS must be greater than 0");
            }
            module.setEcts(moduleDetails.getEcts());
        }
        
        if (moduleDetails.getType() != null) {
            module.setType(moduleDetails.getType());
        }
        
        if (moduleDetails.getNiveau() != null) {
            module.setNiveau(moduleDetails.getNiveau());
        }
        
        if (moduleDetails.getTaughtUnitsPerSemester() != null) {
            module.setTaughtUnitsPerSemester(moduleDetails.getTaughtUnitsPerSemester());
        }
        
        if (moduleDetails.getPrivateStudyTime() != null) {
            module.setPrivateStudyTime(moduleDetails.getPrivateStudyTime());
        }
        
        if (moduleDetails.getProgramme() != null && moduleDetails.getProgramme().getId() != null) {
            programmeRepository.findById(moduleDetails.getProgramme().getId())
                .orElseThrow(() -> new RuntimeException("Programme not found"));
            module.setProgramme(moduleDetails.getProgramme());
        }
        
        if (moduleDetails.getModuleCoordinator() != null && moduleDetails.getModuleCoordinator().getId() != null) {
            lecturerRepository.findById(moduleDetails.getModuleCoordinator().getId())
                .orElseThrow(() -> new RuntimeException("Lecturer not found"));
            module.setModuleCoordinator(moduleDetails.getModuleCoordinator());
        }
        
        if (moduleDetails.getExamProcedure() != null) {
            module.setExamProcedure(moduleDetails.getExamProcedure());
        }
        
        if (moduleDetails.getRequirements() != null) {
            module.setRequirements(moduleDetails.getRequirements());
        }
        
        if (moduleDetails.getContent() != null) {
            module.setContent(moduleDetails.getContent());
        }
        
        if (moduleDetails.getLearningOutcomes() != null) {
            module.setLearningOutcomes(moduleDetails.getLearningOutcomes());
        }
        
        if (moduleDetails.getLiterature() != null) {
            module.setLiterature(moduleDetails.getLiterature());
        }
        
        return moduleRepository.save(module);
    }
    
    @Transactional
    public void deleteModule(String id) {
        Module module = moduleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
        
        // Check if module has any courses
        if (module.getCourses() != null && !module.getCourses().isEmpty()) {
            throw new RuntimeException("Cannot delete module with associated courses");
        }
        
        moduleRepository.deleteById(id);
    }
    
    public long getTotalEctsForProgramme(String programmeId) {
        return moduleRepository.sumEctsByProgrammeId(programmeId);
    }
    
    public List<Module> searchModules(String keyword) {
        return moduleRepository.searchModules(keyword);
    }
}
