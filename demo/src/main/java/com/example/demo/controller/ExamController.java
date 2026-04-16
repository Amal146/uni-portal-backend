package com.example.demo.controller;

import com.example.demo.dto.ExamDTO;
import com.example.demo.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamController {
    private final ExamService examService;

    @GetMapping
    public ResponseEntity<List<ExamDTO>> getAllExams() {
        return ResponseEntity.ok(examService.getAllExams());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamDTO> getExamById(@PathVariable String id) {
        return ResponseEntity.ok(examService.getExamById(id));
    }

    @PostMapping
    public ResponseEntity<ExamDTO> createExam(@RequestBody ExamDTO exam) {
        return new ResponseEntity<>(examService.createExam(exam), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamDTO> updateExam(@PathVariable String id, @RequestBody ExamDTO exam) {
        return ResponseEntity.ok(examService.updateExam(id, exam));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable String id) {
        examService.deleteExam(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<ExamDTO>> getExamsByCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(examService.getExamsByCourseId(courseId));
    }

    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<List<ExamDTO>> getExamsBySemesterId(@PathVariable String semesterId) {
        return ResponseEntity.ok(examService.getExamsBySemesterId(semesterId));
    }

    @GetMapping("/module/{moduleId}")
    public ResponseEntity<List<ExamDTO>> getExamsByModuleId(@PathVariable String moduleId) {
        return ResponseEntity.ok(examService.getExamsByModuleId(moduleId));
    }
}