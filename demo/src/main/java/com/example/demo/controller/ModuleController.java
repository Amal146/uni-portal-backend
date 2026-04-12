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

    @GetMapping("/code/{moduleCode}")
    public ResponseEntity<Module> getModuleByModuleCode(@PathVariable String moduleCode) {
        return ResponseEntity.ok(moduleService.getModuleByModuleCode(moduleCode));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Module>> getModulesByType(@PathVariable Module.ModuleType type) {
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
}