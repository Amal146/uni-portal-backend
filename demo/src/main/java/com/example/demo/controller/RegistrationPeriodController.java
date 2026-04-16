package com.example.demo.controller;

import com.example.demo.dto.RegistrationPeriodDTO;
import com.example.demo.service.RegistrationPeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



// Updated RegistrationPeriodController that returns DTOs
@RestController
@RequestMapping("/registration-periods")
@RequiredArgsConstructor
public class RegistrationPeriodController {
    private final RegistrationPeriodService registrationPeriodService;

    @GetMapping
    public ResponseEntity<List<RegistrationPeriodDTO>> getAllRegistrationPeriods() {
        return ResponseEntity.ok(registrationPeriodService.getAllRegistrationPeriods());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationPeriodDTO> getRegistrationPeriodById(@PathVariable String id) {
        return ResponseEntity.ok(registrationPeriodService.getRegistrationPeriodById(id));
    }

    @PostMapping
    public ResponseEntity<RegistrationPeriodDTO> createRegistrationPeriod(@RequestBody RegistrationPeriodDTO period) {
        return new ResponseEntity<>(registrationPeriodService.createRegistrationPeriod(period), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistrationPeriodDTO> updateRegistrationPeriod(@PathVariable String id, @RequestBody RegistrationPeriodDTO period) {
        return ResponseEntity.ok(registrationPeriodService.updateRegistrationPeriod(id, period));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistrationPeriod(@PathVariable String id) {
        registrationPeriodService.deleteRegistrationPeriod(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<List<RegistrationPeriodDTO>> getPeriodsBySemesterId(@PathVariable String semesterId) {
        return ResponseEntity.ok(registrationPeriodService.getPeriodsBySemesterId(semesterId));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<RegistrationPeriodDTO>> getPeriodsByType(@PathVariable String type) {
        return ResponseEntity.ok(registrationPeriodService.getPeriodsByType(type));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<RegistrationPeriodDTO>> getPeriodsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(registrationPeriodService.getPeriodsByStatus(status));
    }

    @GetMapping("/active")
    public ResponseEntity<RegistrationPeriodDTO> getActiveRegistrationPeriod() {
        return ResponseEntity.ok(registrationPeriodService.getActiveRegistrationPeriod());
    }
}