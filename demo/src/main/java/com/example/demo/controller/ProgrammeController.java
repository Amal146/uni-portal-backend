package com.example.demo.controller;

import com.example.demo.model.Programme;
import com.example.demo.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programmes")
public class ProgrammeController {
    
    @Autowired
    private ProgrammeService programmeService;
    
    @GetMapping
    public ResponseEntity<List<Programme>> getAllProgrammes() {
        return ResponseEntity.ok(programmeService.getAllProgrammes());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Programme> getProgrammeById(@PathVariable String id) {
        return programmeService.getProgrammeById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Programme> createProgramme(@RequestBody Programme programme) {
        return new ResponseEntity<>(programmeService.createProgramme(programme), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Programme> updateProgramme(@PathVariable String id, @RequestBody Programme programme) {
        try {
            return ResponseEntity.ok(programmeService.updateProgramme(id, programme));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramme(@PathVariable String id) {
        programmeService.deleteProgramme(id);
        return ResponseEntity.noContent().build();
    }
}
