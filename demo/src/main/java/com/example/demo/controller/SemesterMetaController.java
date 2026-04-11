package com.example.demo.controller;

import com.example.demo.model.SemesterMeta;
import com.example.demo.service.SemesterMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/semesters")
@CrossOrigin(origins = "*")
public class SemesterMetaController {
    
    @Autowired
    private SemesterMetaService semesterMetaService;
    
    @GetMapping
    public ResponseEntity<List<SemesterMeta>> getAllSemesters() {
        return ResponseEntity.ok(semesterMetaService.getAllSemesters());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SemesterMeta> getSemesterById(@PathVariable String id) {
        return semesterMetaService.getSemesterById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<SemesterMeta>> getActiveSemesters() {
        return ResponseEntity.ok(semesterMetaService.getActiveSemesters());
    }
    
    @PostMapping
    public ResponseEntity<SemesterMeta> createSemester(@RequestBody SemesterMeta semester) {
        return new ResponseEntity<>(semesterMetaService.createSemester(semester), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SemesterMeta> updateSemester(@PathVariable String id, @RequestBody SemesterMeta semester) {
        try {
            return ResponseEntity.ok(semesterMetaService.updateSemester(id, semester));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}