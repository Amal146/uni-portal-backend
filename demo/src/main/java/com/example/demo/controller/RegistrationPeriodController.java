package com.example.demo.controller;

import com.example.demo.model.RegistrationPeriod;
import com.example.demo.service.RegistrationPeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registration-periods")
@RequiredArgsConstructor
public class RegistrationPeriodController {
    private final RegistrationPeriodService registrationPeriodService;

    @GetMapping
    public ResponseEntity<List<RegistrationPeriod>> getAllRegistrationPeriods() {
        return ResponseEntity.ok(registrationPeriodService.getAllRegistrationPeriods());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationPeriod> getRegistrationPeriodById(@PathVariable String id) {
        return ResponseEntity.ok(registrationPeriodService.getRegistrationPeriodById(id));
    }

    @PostMapping
    public ResponseEntity<RegistrationPeriod> createRegistrationPeriod(@RequestBody RegistrationPeriod period) {
        return new ResponseEntity<>(registrationPeriodService.createRegistrationPeriod(period), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistrationPeriod> updateRegistrationPeriod(@PathVariable String id, @RequestBody RegistrationPeriod period) {
        return ResponseEntity.ok(registrationPeriodService.updateRegistrationPeriod(id, period));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistrationPeriod(@PathVariable String id) {
        registrationPeriodService.deleteRegistrationPeriod(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<List<RegistrationPeriod>> getPeriodsBySemesterId(@PathVariable String semesterId) {
        return ResponseEntity.ok(registrationPeriodService.getPeriodsBySemesterId(semesterId));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<RegistrationPeriod>> getPeriodsByType(@PathVariable RegistrationPeriod.RegistrationType type) {
        return ResponseEntity.ok(registrationPeriodService.getPeriodsByType(type));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<RegistrationPeriod>> getPeriodsByStatus(@PathVariable RegistrationPeriod.RegistrationStatus status) {
        return ResponseEntity.ok(registrationPeriodService.getPeriodsByStatus(status));
    }

    @GetMapping("/active")
    public ResponseEntity<RegistrationPeriod> getActiveRegistrationPeriod() {
        return ResponseEntity.ok(registrationPeriodService.getActiveRegistrationPeriod());
    }
}