package com.example.demo.controller;

import com.example.demo.dto.ExamRegistrationDTO;
import com.example.demo.service.ExamRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exam-registrations")
@CrossOrigin(origins = "*")
public class ExamRegistrationController {
    
    @Autowired
    private ExamRegistrationService service;
    
    @GetMapping
    public ResponseEntity<List<ExamRegistrationDTO>> getAll() {
        return ResponseEntity.ok(service.getAllExamRegistrations());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ExamRegistrationDTO> getById(@PathVariable String id) {
        return service.getExamRegistrationById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ExamRegistrationDTO>> getByStudent(@PathVariable String studentId) {
        return ResponseEntity.ok(service.getByStudentId(studentId));
    }
    
    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<ExamRegistrationDTO>> getByExam(@PathVariable String examId) {
        return ResponseEntity.ok(service.getByExamId(examId));
    }
    
    @PostMapping
    public ResponseEntity<ExamRegistrationDTO> create(@RequestBody ExamRegistrationDTO dto) {
        return new ResponseEntity<>(service.createExamRegistration(dto), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteExamRegistration(id);
        return ResponseEntity.noContent().build();
    }
}
