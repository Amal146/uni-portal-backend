package com.example.demo.controller;

import com.example.demo.model.Module;
import com.example.demo.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModuleController {
    
    @Autowired
    private ModuleService moduleService;
    
    @GetMapping
    public ResponseEntity<List<Module>> getAllModules() {
        return ResponseEntity.ok(moduleService.getAllModules());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable String id) {
        return moduleService.getModuleById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<Module>> getModulesByProgramme(@PathVariable String programmeId) {
        return ResponseEntity.ok(moduleService.getModulesByProgramme(programmeId));
    }
    
    @PostMapping
    public ResponseEntity<Module> createModule(@RequestBody Module module) {
        return new ResponseEntity<>(moduleService.createModule(module), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable String id, @RequestBody Module module) {
        try {
            return ResponseEntity.ok(moduleService.updateModule(id, module));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable String id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
}
