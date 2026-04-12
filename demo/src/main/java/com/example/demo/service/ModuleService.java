package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Exam;
import com.example.demo.model.Module;
import com.example.demo.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ModuleService {
    private final ModuleRepository moduleRepository;

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Module getModuleById(String id) {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
    }

    @Transactional
    public Module createModule(Module module) {
        if (module.getId() == null) {
            module.setId(UUID.randomUUID().toString());
        }
        return moduleRepository.save(module);
    }

    @Transactional
    public Module updateModule(String id, Module moduleDetails) {
        Module module = getModuleById(id);
        
        // Update only the fields that exist in the new model
        module.setName(moduleDetails.getName());
        module.setShortName(moduleDetails.getShortName());
        module.setProgramme(moduleDetails.getProgramme());
        module.setType(moduleDetails.getType());
        module.setTotalEcts(moduleDetails.getTotalEcts());
        module.setCoordinator(moduleDetails.getCoordinator());
        
        // Note: courses and exams are managed separately through their own services
        // to avoid overriding the collections
        
        return moduleRepository.save(module);
    }

    @Transactional
    public void deleteModule(String id) {
        Module module = getModuleById(id);
        moduleRepository.delete(module);
    }

    public List<Module> getModulesByProgrammeId(String programmeId) {
        return moduleRepository.findByProgrammeId(programmeId);
    }

    public List<Module> getModulesByCoordinatorId(String lecturerId) {
        return moduleRepository.findByCoordinatorId(lecturerId);
    }

    public List<Module> getModulesByType(String type) {
        return moduleRepository.findByType(type);
    }

    public Long getTotalEctsByProgrammeId(String programmeId) {
        return moduleRepository.sumTotalEctsByProgrammeId(programmeId);
    }

    public List<Module> searchModules(String keyword) {
        return moduleRepository.searchModules(keyword);
    }
    
    // Additional useful service methods based on the new repository methods
    
    public List<Module> getModulesByTotalEctsRange(Integer minEcts, Integer maxEcts) {
        return moduleRepository.findByTotalEctsBetween(minEcts, maxEcts);
    }
    
    public List<Module> getModulesWithoutCoordinator() {
        return moduleRepository.findByCoordinatorIsNull();
    }
    
    public List<Module> getModulesByCoordinatorAndType(String lecturerId, String type) {
        return moduleRepository.findByCoordinatorIdAndType(lecturerId, type);
    }
    
    public List<Object[]> getModuleCountByType() {
        return moduleRepository.countModulesByType();
    }
    
    public List<Module> getModulesByProgrammeAndType(String programmeId, String type) {
        return moduleRepository.findByProgrammeIdAndType(programmeId, type);
    }
    
    public List<Module> getModulesWithCourses() {
        return moduleRepository.findModulesWithCourses();
    }
    
    public List<Module> getModulesWithExams() {
        return moduleRepository.findModulesWithExams();
    }
    
    // Helper method to add a course to a module (transactional)
    @Transactional
    public Module addCourseToModule(String moduleId, Course course) {
        Module module = getModuleById(moduleId);
        module.addCourse(course);
        return moduleRepository.save(module);
    }
    
    // Helper method to add an exam to a module (transactional)
    @Transactional
    public Module addExamToModule(String moduleId, Exam exam) {
        Module module = getModuleById(moduleId);
        module.addExam(exam);
        return moduleRepository.save(module);
    }
}