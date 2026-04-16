package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudentDTOs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getStudentDTOById(id));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<StudentDTO>> getStudentsByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(studentService.getStudentDTOsByProgrammeId(programmeId));
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<StudentDTO>> getStudentsByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(studentService.getStudentDTOsByLastName(lastName));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<StudentDTO> getStudentByEmail(@PathVariable String email) {
        return ResponseEntity.ok(studentService.getStudentDTOByEmail(email));
    }

    @GetMapping("/search")
    public ResponseEntity<StudentDTO> getStudentByFullName(
            @RequestParam String firstName, @RequestParam String lastName) {
        return ResponseEntity.ok(studentService.getStudentDTOByFullName(firstName, lastName));
    }
}