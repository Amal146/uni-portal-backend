package com.example.demo.controller;

import com.example.demo.model.Semester;
import com.example.demo.service.SemesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semesters")
@RequiredArgsConstructor
public class SemesterController {
    private final SemesterService semesterService;

    @GetMapping
    public ResponseEntity<List<Semester>> getAllSemesters() {
        return ResponseEntity.ok(semesterService.getAllSemesters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semester> getSemesterById(@PathVariable String id) {
        return ResponseEntity.ok(semesterService.getSemesterById(id));
    }

    @PostMapping
    public ResponseEntity<Semester> createSemester(@RequestBody Semester semester) {
        return new ResponseEntity<>(semesterService.createSemester(semester), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Semester> updateSemester(@PathVariable String id, @RequestBody Semester semester) {
        return ResponseEntity.ok(semesterService.updateSemester(id, semester));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemester(@PathVariable String id) {
        semesterService.deleteSemester(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/season/{season}")
    public ResponseEntity<List<Semester>> getSemestersBySeason(@PathVariable Semester.Season season) {
        return ResponseEntity.ok(semesterService.getSemestersBySeason(season));
    }

    @GetMapping("/year/{calYear}")
    public ResponseEntity<List<Semester>> getSemestersByCalYear(@PathVariable Integer calYear) {
        return ResponseEntity.ok(semesterService.getSemestersByCalYear(calYear));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Semester>> getSemestersByStatus(@PathVariable String status) {
        return ResponseEntity.ok(semesterService.getSemestersByStatus(status));
    }

    @GetMapping("/lookup")
    public ResponseEntity<Semester> getSemesterByLabelAndCalYear(
            @RequestParam String label, @RequestParam Integer calYear) {
        return ResponseEntity.ok(semesterService.getSemesterByLabelAndCalYear(label, calYear));
    }
}