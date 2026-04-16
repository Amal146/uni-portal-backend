package com.example.demo.service;

import com.example.demo.dto.ModuleDTO;
import com.example.demo.model.Lecturer;
import com.example.demo.model.Module;
import com.example.demo.model.Programme;
import com.example.demo.repository.LecturerRepository;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.repository.ProgrammeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



// Updated ModuleService that returns DTOs
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ModuleService {
    private final ModuleRepository moduleRepository;
    private final ProgrammeRepository programmeRepository;
    private final LecturerRepository lecturerRepository;

    public List<ModuleDTO> getAllModules() {
        return ModuleDTO.fromEntities(moduleRepository.findAll());
    }

    public ModuleDTO getModuleById(String id) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
        return ModuleDTO.fromEntity(module);
    }

    @Transactional
    public ModuleDTO createModule(ModuleDTO moduleDTO) {
        Module module = convertToEntity(moduleDTO);
        if (module.getId() == null) {
            module.setId(java.util.UUID.randomUUID().toString());
        }
        Module saved = moduleRepository.save(module);
        return ModuleDTO.fromEntity(saved);
    }

    @Transactional
    public ModuleDTO updateModule(String id, ModuleDTO moduleDetailsDTO) {
        Module module = getModuleEntityById(id);
        updateModuleEntity(module, moduleDetailsDTO);
        Module updated = moduleRepository.save(module);
        return ModuleDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteModule(String id) {
        Module module = getModuleEntityById(id);
        moduleRepository.delete(module);
    }

    public List<ModuleDTO> getModulesByProgrammeId(String programmeId) {
        return ModuleDTO.fromEntities(moduleRepository.findByProgrammeId(programmeId));
    }

    public List<ModuleDTO> getModulesByCoordinatorId(String lecturerId) {
        return ModuleDTO.fromEntities(moduleRepository.findByCoordinatorId(lecturerId));
    }

    public List<ModuleDTO> getModulesByType(String type) {
        return ModuleDTO.fromEntities(moduleRepository.findByType(type));
    }

    public Long getTotalEctsByProgrammeId(String programmeId) {
        return moduleRepository.sumTotalEctsByProgrammeId(programmeId);
    }

    public List<ModuleDTO> searchModules(String keyword) {
        return ModuleDTO.fromEntities(moduleRepository.searchModules(keyword));
    }
    
    public List<ModuleDTO> getModulesByTotalEctsRange(Integer minEcts, Integer maxEcts) {
        return ModuleDTO.fromEntities(moduleRepository.findByTotalEctsBetween(minEcts, maxEcts));
    }
    
    public List<ModuleDTO> getModulesWithoutCoordinator() {
        return ModuleDTO.fromEntities(moduleRepository.findByCoordinatorIsNull());
    }
    
    public List<ModuleDTO> getModulesByCoordinatorAndType(String lecturerId, String type) {
        return ModuleDTO.fromEntities(moduleRepository.findByCoordinatorIdAndType(lecturerId, type));
    }
    
    public List<Object[]> getModuleCountByType() {
        return moduleRepository.countModulesByType();
    }
    
    public List<ModuleDTO> getModulesByProgrammeAndType(String programmeId, String type) {
        return ModuleDTO.fromEntities(moduleRepository.findByProgrammeIdAndType(programmeId, type));
    }
    
    public List<ModuleDTO> getModulesWithCourses() {
        return ModuleDTO.fromEntities(moduleRepository.findModulesWithCourses());
    }
    
    public List<ModuleDTO> getModulesWithExams() {
        return ModuleDTO.fromEntities(moduleRepository.findModulesWithExams());
    }
    
    // Helper methods for internal use
    private Module getModuleEntityById(String id) {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
    }
    
    private Module convertToEntity(ModuleDTO dto) {
        Module module = new Module();
        module.setId(dto.getId());
        module.setName(dto.getName());
        module.setShortName(dto.getShortName());
        module.setType(dto.getType());
        module.setTotalEcts(dto.getTotalEcts());
        
        // Set Programme if programmeId is provided
        if (dto.getProgrammeId() != null) {
            Programme programme = programmeRepository.findById(dto.getProgrammeId())
                    .orElseThrow(() -> new RuntimeException("Programme not found with id: " + dto.getProgrammeId()));
            module.setProgramme(programme);
        }
        
        // Set Coordinator if coordinatorId is provided
        if (dto.getCoordinatorId() != null) {
            Lecturer coordinator = lecturerRepository.findById(dto.getCoordinatorId())
                    .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + dto.getCoordinatorId()));
            module.setCoordinator(coordinator);
        }
        
        return module;
    }
    
    private void updateModuleEntity(Module module, ModuleDTO dto) {
        module.setName(dto.getName());
        module.setShortName(dto.getShortName());
        module.setType(dto.getType());
        module.setTotalEcts(dto.getTotalEcts());
        
        // Update Programme if programmeId is provided
        if (dto.getProgrammeId() != null) {
            Programme programme = programmeRepository.findById(dto.getProgrammeId())
                    .orElseThrow(() -> new RuntimeException("Programme not found with id: " + dto.getProgrammeId()));
            module.setProgramme(programme);
        }
        
        // Update Coordinator if coordinatorId is provided
        if (dto.getCoordinatorId() != null) {
            Lecturer coordinator = lecturerRepository.findById(dto.getCoordinatorId())
                    .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + dto.getCoordinatorId()));
            module.setCoordinator(coordinator);
        }
    }
    
    // Relationship management methods (if needed)
    @Transactional
    public ModuleDTO addCourseToModule(String moduleId, String courseId) {
        // This would require CourseRepository and would update the relationship
        // Implementation depends on your specific needs
        Module module = getModuleEntityById(moduleId);
        // Course course = courseRepository.findById(courseId).orElseThrow();
        // module.addCourse(course);
        Module updated = moduleRepository.save(module);
        return ModuleDTO.fromEntity(updated);
    }
}
