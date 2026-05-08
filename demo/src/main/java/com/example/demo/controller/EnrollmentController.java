package com.example.demo.controller;

import com.example.demo.dto.EnrollmentDTO;
import com.example.demo.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> getEnrollmentById(@PathVariable String id) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentById(id));
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> createEnrollment(@RequestBody EnrollmentDTO enrollment) {
        return new ResponseEntity<>(enrollmentService.createEnrollment(enrollment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> updateEnrollment(@PathVariable String id, @RequestBody EnrollmentDTO enrollment) {
        return ResponseEntity.ok(enrollmentService.updateEnrollment(id, enrollment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable String id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentsByStudentId(studentId));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentsByCourseId(courseId));
    }

    @GetMapping("/student/{studentId}/status/{status}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByStudentIdAndStatus(
            @PathVariable String studentId, @PathVariable String status) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentsByStudentIdAndStatus(studentId, status));
    }

    @GetMapping("/counts")
    public ResponseEntity<Map<String, Long>> getRegisteredCounts(@RequestParam String semesterId) {
         return ResponseEntity.ok(enrollmentService.getRegisteredCountsBySemesterId(semesterId));
    }
}