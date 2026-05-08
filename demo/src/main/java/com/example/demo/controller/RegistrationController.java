package com.example.demo.controller;

import com.example.demo.dto.RegistrationDTO;
import com.example.demo.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Updated RegistrationController that returns DTOs
@RestController
@RequestMapping("/registrations")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<List<RegistrationDTO>> getAllRegistrations() {
        return ResponseEntity.ok(registrationService.getAllRegistrations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDTO> getRegistrationById(@PathVariable String id) {
        return ResponseEntity.ok(registrationService.getRegistrationById(id));
    }

    @PostMapping
    public ResponseEntity<RegistrationDTO> createRegistration(@RequestBody RegistrationDTO registration) {
        return new ResponseEntity<>(registrationService.createRegistration(registration), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistrationDTO> updateRegistration(@PathVariable String id, @RequestBody RegistrationDTO registration) {
        return ResponseEntity.ok(registrationService.updateRegistration(id, registration));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable String id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.noContent().build();
    }

    
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<RegistrationDTO>> getRegistrationsByCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(registrationService.getRegistrationsByCourseId(courseId));
    }

    @GetMapping("/period/{periodId}")
    public ResponseEntity<List<RegistrationDTO>> getRegistrationsByRegistrationPeriodId(@PathVariable String periodId) {
        return ResponseEntity.ok(registrationService.getRegistrationsByRegistrationPeriodId(periodId));
    }



    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<RegistrationDTO> getRegistrationByStudentIdAndCourseId(
            @PathVariable String studentId, @PathVariable String courseId) {
        return ResponseEntity.ok(registrationService.getRegistrationByStudentIdAndCourseId(studentId, courseId));
    }
}