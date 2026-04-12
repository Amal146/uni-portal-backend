package com.example.demo.controller;

import com.example.demo.model.Exam;
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
    public ResponseEntity<List<Exam>> getAllExams() {
        return ResponseEntity.ok(examService.getAllExams());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable String id) {
        return ResponseEntity.ok(examService.getExamById(id));
    }

    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        return new ResponseEntity<>(examService.createExam(exam), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable String id, @RequestBody Exam exam) {
        return ResponseEntity.ok(examService.updateExam(id, exam));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable String id) {
        examService.deleteExam(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Exam>> getExamsByCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(examService.getExamsByCourseId(courseId));
    }

    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<List<Exam>> getExamsBySemesterId(@PathVariable String semesterId) {
        return ResponseEntity.ok(examService.getExamsBySemesterId(semesterId));
    }

    @GetMapping("/module/{moduleId}")
    public ResponseEntity<List<Exam>> getExamsByModuleId(@PathVariable String moduleId) {
        return ResponseEntity.ok(examService.getExamsByModuleId(moduleId));
    }
}