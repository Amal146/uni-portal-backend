package com.example.demo.controller;

import com.example.demo.model.Module;
import com.example.demo.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService moduleService;

    @GetMapping
    public ResponseEntity<List<Module>> getAllModules() {
        return ResponseEntity.ok(moduleService.getAllModules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable String id) {
        return ResponseEntity.ok(moduleService.getModuleById(id));
    }

    @PostMapping
    public ResponseEntity<Module> createModule(@RequestBody Module module) {
        return new ResponseEntity<>(moduleService.createModule(module), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable String id, @RequestBody Module module) {
        return ResponseEntity.ok(moduleService.updateModule(id, module));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable String id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<Module>> getModulesByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(moduleService.getModulesByProgrammeId(programmeId));
    }

    @GetMapping("/coordinator/{lecturerId}")
    public ResponseEntity<List<Module>> getModulesByCoordinatorId(@PathVariable String lecturerId) {
        return ResponseEntity.ok(moduleService.getModulesByCoordinatorId(lecturerId));
    }

    // Removed: getModuleByModuleCode endpoint - moduleCode doesn't exist in the model
    
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Module>> getModulesByType(@PathVariable String type) {
        return ResponseEntity.ok(moduleService.getModulesByType(type));
    }

    @GetMapping("/programme/{programmeId}/total-ects")
    public ResponseEntity<Long> getTotalEctsByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(moduleService.getTotalEctsByProgrammeId(programmeId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Module>> searchModules(@RequestParam String keyword) {
        return ResponseEntity.ok(moduleService.searchModules(keyword));
    }
    
    // Additional endpoints for the new service methods
    
    @GetMapping("/ects-range")
    public ResponseEntity<List<Module>> getModulesByTotalEctsRange(
            @RequestParam Integer minEcts,
            @RequestParam Integer maxEcts) {
        return ResponseEntity.ok(moduleService.getModulesByTotalEctsRange(minEcts, maxEcts));
    }
    
    @GetMapping("/without-coordinator")
    public ResponseEntity<List<Module>> getModulesWithoutCoordinator() {
        return ResponseEntity.ok(moduleService.getModulesWithoutCoordinator());
    }
    
    @GetMapping("/coordinator/{lecturerId}/type/{type}")
    public ResponseEntity<List<Module>> getModulesByCoordinatorAndType(
            @PathVariable String lecturerId,
            @PathVariable String type) {
        return ResponseEntity.ok(moduleService.getModulesByCoordinatorAndType(lecturerId, type));
    }
    
    @GetMapping("/count-by-type")
    public ResponseEntity<List<Object[]>> getModuleCountByType() {
        return ResponseEntity.ok(moduleService.getModuleCountByType());
    }
    
    @GetMapping("/programme/{programmeId}/type/{type}")
    public ResponseEntity<List<Module>> getModulesByProgrammeAndType(
            @PathVariable String programmeId,
            @PathVariable String type) {
        return ResponseEntity.ok(moduleService.getModulesByProgrammeAndType(programmeId, type));
    }
    
    @GetMapping("/with-courses")
    public ResponseEntity<List<Module>> getModulesWithCourses() {
        return ResponseEntity.ok(moduleService.getModulesWithCourses());
    }
    
    @GetMapping("/with-exams")
    public ResponseEntity<List<Module>> getModulesWithExams() {
        return ResponseEntity.ok(moduleService.getModulesWithExams());
    }
    
    // Endpoints for managing relationships (requires DTOs for Course and Exam in request body)
    /*
    @PostMapping("/{moduleId}/courses")
    public ResponseEntity<Module> addCourseToModule(
            @PathVariable String moduleId,
            @RequestBody Course course) {
        return ResponseEntity.ok(moduleService.addCourseToModule(moduleId, course));
    }
    
    @PostMapping("/{moduleId}/exams")
    public ResponseEntity<Module> addExamToModule(
            @PathVariable String moduleId,
            @RequestBody Exam exam) {
        return ResponseEntity.ok(moduleService.addExamToModule(moduleId, exam));
    }
    */
}