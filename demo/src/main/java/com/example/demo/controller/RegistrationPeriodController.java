package com.example.demo.controller;

import com.example.demo.model.RegistrationPeriod;
import com.example.demo.service.RegistrationPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/registration-periods")
@CrossOrigin(origins = "*")
public class RegistrationPeriodController {
    
    @Autowired
    private RegistrationPeriodService registrationPeriodService;
    
    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<List<RegistrationPeriod>> getPeriodsBySemester(@PathVariable String semesterId) {
        return ResponseEntity.ok(registrationPeriodService.getPeriodsBySemester(semesterId));
    }
    
    @GetMapping("/active")
    public ResponseEntity<RegistrationPeriod> getActivePeriod(@RequestParam LocalDate date) {
        return registrationPeriodService.getActivePeriod(date)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<RegistrationPeriod> createPeriod(@RequestBody RegistrationPeriod period) {
        return new ResponseEntity<>(registrationPeriodService.createPeriod(period), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RegistrationPeriod> updatePeriod(@PathVariable String id, @RequestBody RegistrationPeriod period) {
        try {
            return ResponseEntity.ok(registrationPeriodService.updatePeriod(id, period));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}