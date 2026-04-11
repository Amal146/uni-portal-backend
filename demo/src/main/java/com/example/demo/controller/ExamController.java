package com.example.demo.controller;

import com.example.demo.dto.ExamDTO;
import com.example.demo.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin(origins = "*")
public class ExamController {
    
    @Autowired
    private ExamService examService;
    
    @GetMapping
    public ResponseEntity<List<ExamDTO>> getAllExams() {
        return ResponseEntity.ok(examService.getAllExams());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ExamDTO> getExamById(@PathVariable String id) {
        return examService.getExamById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<ExamDTO>> getExamsByCourse(@PathVariable String courseId) {
        return ResponseEntity.ok(examService.getExamsByCourse(courseId));
    }
    
    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<List<ExamDTO>> getExamsBySemester(@PathVariable String semesterId) {
        return ResponseEntity.ok(examService.getExamsBySemester(semesterId));
    }
    
    @PostMapping
    public ResponseEntity<ExamDTO> createExam(@RequestBody ExamDTO examDTO) {
        return new ResponseEntity<>(examService.createExam(examDTO), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ExamDTO> updateExam(@PathVariable String id, @RequestBody ExamDTO examDTO) {
        try {
            return ResponseEntity.ok(examService.updateExam(id, examDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable String id) {
        examService.deleteExam(id);
        return ResponseEntity.noContent().build();
    }
}
