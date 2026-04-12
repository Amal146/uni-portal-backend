package com.example.demo.service;

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
        module.setModuleCode(moduleDetails.getModuleCode());
        module.setName(moduleDetails.getName());
        module.setEcts(moduleDetails.getEcts());
        module.setType(moduleDetails.getType());
        module.setNiveau(moduleDetails.getNiveau());
        module.setTaughtUnitsPerSemester(moduleDetails.getTaughtUnitsPerSemester());
        module.setPrivateStudyTime(moduleDetails.getPrivateStudyTime());
        module.setProgramme(moduleDetails.getProgramme());
        module.setModuleCoordinator(moduleDetails.getModuleCoordinator());
        module.setExamProcedure(moduleDetails.getExamProcedure());
        module.setRequirements(moduleDetails.getRequirements());
        module.setContent(moduleDetails.getContent());
        module.setLearningOutcomes(moduleDetails.getLearningOutcomes());
        module.setLiterature(moduleDetails.getLiterature());
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
        return moduleRepository.findByModuleCoordinatorId(lecturerId);
    }

    public Module getModuleByModuleCode(String moduleCode) {
        return moduleRepository.findByModuleCode(moduleCode)
                .orElseThrow(() -> new RuntimeException("Module not found with code: " + moduleCode));
    }

    public List<Module> getModulesByType(Module.ModuleType type) {
        return moduleRepository.findByType(type);
    }

    public Long getTotalEctsByProgrammeId(String programmeId) {
        return moduleRepository.sumEctsByProgrammeId(programmeId);
    }

    public List<Module> searchModules(String keyword) {
        return moduleRepository.searchModules(keyword);
    }
}
