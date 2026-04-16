package com.example.demo.controller;

import com.example.demo.dto.ModuleDTO;
import com.example.demo.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Updated ModuleController that returns DTOs
@RestController
@RequestMapping("/modules")
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService moduleService;

    @GetMapping
    public ResponseEntity<List<ModuleDTO>> getAllModules() {
        return ResponseEntity.ok(moduleService.getAllModules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDTO> getModuleById(@PathVariable String id) {
        return ResponseEntity.ok(moduleService.getModuleById(id));
    }

    @PostMapping
    public ResponseEntity<ModuleDTO> createModule(@RequestBody ModuleDTO module) {
        return new ResponseEntity<>(moduleService.createModule(module), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuleDTO> updateModule(@PathVariable String id, @RequestBody ModuleDTO module) {
        return ResponseEntity.ok(moduleService.updateModule(id, module));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable String id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<ModuleDTO>> getModulesByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(moduleService.getModulesByProgrammeId(programmeId));
    }

    @GetMapping("/coordinator/{lecturerId}")
    public ResponseEntity<List<ModuleDTO>> getModulesByCoordinatorId(@PathVariable String lecturerId) {
        return ResponseEntity.ok(moduleService.getModulesByCoordinatorId(lecturerId));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<ModuleDTO>> getModulesByType(@PathVariable String type) {
        return ResponseEntity.ok(moduleService.getModulesByType(type));
    }

    @GetMapping("/programme/{programmeId}/total-ects")
    public ResponseEntity<Long> getTotalEctsByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(moduleService.getTotalEctsByProgrammeId(programmeId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ModuleDTO>> searchModules(@RequestParam String keyword) {
        return ResponseEntity.ok(moduleService.searchModules(keyword));
    }
    
    @GetMapping("/ects-range")
    public ResponseEntity<List<ModuleDTO>> getModulesByTotalEctsRange(
            @RequestParam Integer minEcts,
            @RequestParam Integer maxEcts) {
        return ResponseEntity.ok(moduleService.getModulesByTotalEctsRange(minEcts, maxEcts));
    }
    
    @GetMapping("/without-coordinator")
    public ResponseEntity<List<ModuleDTO>> getModulesWithoutCoordinator() {
        return ResponseEntity.ok(moduleService.getModulesWithoutCoordinator());
    }
    
    @GetMapping("/coordinator/{lecturerId}/type/{type}")
    public ResponseEntity<List<ModuleDTO>> getModulesByCoordinatorAndType(
            @PathVariable String lecturerId,
            @PathVariable String type) {
        return ResponseEntity.ok(moduleService.getModulesByCoordinatorAndType(lecturerId, type));
    }
    
    @GetMapping("/count-by-type")
    public ResponseEntity<List<Object[]>> getModuleCountByType() {
        return ResponseEntity.ok(moduleService.getModuleCountByType());
    }
    
    @GetMapping("/programme/{programmeId}/type/{type}")
    public ResponseEntity<List<ModuleDTO>> getModulesByProgrammeAndType(
            @PathVariable String programmeId,
            @PathVariable String type) {
        return ResponseEntity.ok(moduleService.getModulesByProgrammeAndType(programmeId, type));
    }
    
    @GetMapping("/with-courses")
    public ResponseEntity<List<ModuleDTO>> getModulesWithCourses() {
        return ResponseEntity.ok(moduleService.getModulesWithCourses());
    }
    
    @GetMapping("/with-exams")
    public ResponseEntity<List<ModuleDTO>> getModulesWithExams() {
        return ResponseEntity.ok(moduleService.getModulesWithExams());
    }
}