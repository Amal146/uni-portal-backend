package com.example.demo.controller;

import com.example.demo.model.Holiday;
import com.example.demo.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/holidays")
@CrossOrigin(origins = "*")
public class HolidayController {
    
    @Autowired
    private HolidayService holidayService;
    
    @GetMapping
    public ResponseEntity<List<Holiday>> getAllHolidays() {
        return ResponseEntity.ok(holidayService.getAllHolidays());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Holiday> getHolidayById(@PathVariable String id) {
        return holidayService.getHolidayById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<List<Holiday>> getHolidaysBySemester(@PathVariable String semesterId) {
        return ResponseEntity.ok(holidayService.getHolidaysBySemester(semesterId));
    }
    
    @PostMapping
    public ResponseEntity<Holiday> createHoliday(@RequestBody Holiday holiday) {
        return new ResponseEntity<>(holidayService.createHoliday(holiday), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Holiday> updateHoliday(@PathVariable String id, @RequestBody Holiday holiday) {
        try {
            return ResponseEntity.ok(holidayService.updateHoliday(id, holiday));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}