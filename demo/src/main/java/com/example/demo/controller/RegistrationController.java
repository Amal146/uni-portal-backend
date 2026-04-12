package com.example.demo.controller;

import com.example.demo.model.Registration;
import com.example.demo.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        return ResponseEntity.ok(registrationService.getAllRegistrations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable String id) {
        return ResponseEntity.ok(registrationService.getRegistrationById(id));
    }

    @PostMapping
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration registration) {
        return new ResponseEntity<>(registrationService.createRegistration(registration), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable String id, @RequestBody Registration registration) {
        return ResponseEntity.ok(registrationService.updateRegistration(id, registration));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable String id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Registration>> getRegistrationsByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(registrationService.getRegistrationsByStudentId(studentId));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Registration>> getRegistrationsByCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(registrationService.getRegistrationsByCourseId(courseId));
    }

    @GetMapping("/period/{periodId}")
    public ResponseEntity<List<Registration>> getRegistrationsByRegistrationPeriodId(@PathVariable String periodId) {
        return ResponseEntity.ok(registrationService.getRegistrationsByRegistrationPeriodId(periodId));
    }

    @GetMapping("/student/{studentId}/status/{status}")
    public ResponseEntity<List<Registration>> getRegistrationsByStudentIdAndStatus(
            @PathVariable String studentId, @PathVariable Registration.RegistrationStatus status) {
        return ResponseEntity.ok(registrationService.getRegistrationsByStudentIdAndStatus(studentId, status));
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Registration> getRegistrationByStudentIdAndCourseId(
            @PathVariable String studentId, @PathVariable String courseId) {
        return ResponseEntity.ok(registrationService.getRegistrationByStudentIdAndCourseId(studentId, courseId));
    }
}