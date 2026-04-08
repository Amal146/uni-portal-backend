package com.example.demo.controller;

import com.example.demo.model.Lecturer;
import com.example.demo.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturers")
public class LecturerController {
    
    @Autowired
    private LecturerService lecturerService;
    
    @GetMapping
    public ResponseEntity<List<Lecturer>> getAllLecturers() {
        return ResponseEntity.ok(lecturerService.getAllLecturers());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Lecturer> getLecturerById(@PathVariable String id) {
        return lecturerService.getLecturerById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<Lecturer> getLecturerByEmail(@PathVariable String email) {
        return lecturerService.getLecturerByEmail(email)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/department/{department}")
    public ResponseEntity<List<Lecturer>> getLecturersByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(lecturerService.getLecturersByDepartment(department));
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Lecturer>> searchLecturers(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return ResponseEntity.ok(lecturerService.searchLecturers(firstName, lastName));
    }
    
    @GetMapping("/department/{department}/count")
    public ResponseEntity<Long> getLecturerCountByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(lecturerService.getLecturerCountByDepartment(department));
    }
    
    @PostMapping
    public ResponseEntity<Lecturer> createLecturer(@RequestBody Lecturer lecturer) {
        try {
            Lecturer createdLecturer = lecturerService.createLecturer(lecturer);
            return new ResponseEntity<>(createdLecturer, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Lecturer> updateLecturer(@PathVariable String id, @RequestBody Lecturer lecturer) {
        try {
            Lecturer updatedLecturer = lecturerService.updateLecturer(id, lecturer);
            return ResponseEntity.ok(updatedLecturer);
        } catch (RuntimeException e) {
            if (e.getMessage().contains("not found")) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecturer(@PathVariable String id) {
        try {
            lecturerService.deleteLecturer(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            if (e.getMessage().contains("not found")) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().build();
        }
    }
}