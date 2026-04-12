package com.example.demo.controller;

import com.example.demo.model.ExamRegistration;
import com.example.demo.service.ExamRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam-registrations")
@RequiredArgsConstructor
public class ExamRegistrationController {
    private final ExamRegistrationService examRegistrationService;

    @GetMapping
    public ResponseEntity<List<ExamRegistration>> getAllExamRegistrations() {
        return ResponseEntity.ok(examRegistrationService.getAllExamRegistrations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamRegistration> getExamRegistrationById(@PathVariable String id) {
        return ResponseEntity.ok(examRegistrationService.getExamRegistrationById(id));
    }

    @PostMapping
    public ResponseEntity<ExamRegistration> createExamRegistration(@RequestBody ExamRegistration registration) {
        return new ResponseEntity<>(examRegistrationService.createExamRegistration(registration), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamRegistration> updateExamRegistration(@PathVariable String id, @RequestBody ExamRegistration registration) {
        return ResponseEntity.ok(examRegistrationService.updateExamRegistration(id, registration));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamRegistration(@PathVariable String id) {
        examRegistrationService.deleteExamRegistration(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ExamRegistration>> getRegistrationsByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(examRegistrationService.getRegistrationsByStudentId(studentId));
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<ExamRegistration>> getRegistrationsByExamId(@PathVariable String examId) {
        return ResponseEntity.ok(examRegistrationService.getRegistrationsByExamId(examId));
    }

    @GetMapping("/student/{studentId}/exam/{examId}")
    public ResponseEntity<ExamRegistration> getRegistrationByStudentIdAndExamId(
            @PathVariable String studentId, @PathVariable String examId) {
        return ResponseEntity.ok(examRegistrationService.getRegistrationByStudentIdAndExamId(studentId, examId));
    }
}