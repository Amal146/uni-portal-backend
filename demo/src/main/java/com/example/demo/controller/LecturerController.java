package com.example.demo.controller;

import com.example.demo.dto.LecturerDTO;
import com.example.demo.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Updated LecturerController that returns DTOs
@RestController
@RequestMapping("/lecturers")
@RequiredArgsConstructor
public class LecturerController {
    private final LecturerService lecturerService;

    @GetMapping
    public ResponseEntity<List<LecturerDTO>> getAllLecturers() {
        return ResponseEntity.ok(lecturerService.getAllLecturers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LecturerDTO> getLecturerById(@PathVariable String id) {
        return ResponseEntity.ok(lecturerService.getLecturerById(id));
    }

    @PostMapping
    public ResponseEntity<LecturerDTO> createLecturer(@RequestBody LecturerDTO lecturer) {
        return new ResponseEntity<>(lecturerService.createLecturer(lecturer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LecturerDTO> updateLecturer(@PathVariable String id, @RequestBody LecturerDTO lecturer) {
        return ResponseEntity.ok(lecturerService.updateLecturer(id, lecturer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecturer(@PathVariable String id) {
        lecturerService.deleteLecturer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<LecturerDTO>> getLecturersByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(lecturerService.getLecturersByDepartment(department));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<LecturerDTO> getLecturerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(lecturerService.getLecturerByEmail(email));
    }

    @GetMapping("/search/firstname")
    public ResponseEntity<List<LecturerDTO>> searchLecturersByFirstName(@RequestParam String firstName) {
        return ResponseEntity.ok(lecturerService.searchLecturersByFirstName(firstName));
    }

    @GetMapping("/search/lastname")
    public ResponseEntity<List<LecturerDTO>> searchLecturersByLastName(@RequestParam String lastName) {
        return ResponseEntity.ok(lecturerService.searchLecturersByLastName(lastName));
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<LecturerDTO>> searchLecturersByName(
            @RequestParam String firstName, @RequestParam String lastName) {
        return ResponseEntity.ok(lecturerService.searchLecturersByName(firstName, lastName));
    }

    @GetMapping("/count/department/{department}")
    public ResponseEntity<Long> countLecturersByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(lecturerService.countLecturersByDepartment(department));
    }
}