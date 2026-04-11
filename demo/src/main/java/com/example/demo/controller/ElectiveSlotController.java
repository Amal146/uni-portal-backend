package com.example.demo.controller;

import com.example.demo.model.ElectiveSlot;
import com.example.demo.service.ElectiveSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/elective-slots")
@CrossOrigin(origins = "*")
public class ElectiveSlotController {
    
    @Autowired
    private ElectiveSlotService electiveSlotService;
    
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ElectiveSlot>> getSlotsByStudent(@PathVariable String studentId) {
        return ResponseEntity.ok(electiveSlotService.getSlotsByStudent(studentId));
    }
    
    @PostMapping
    public ResponseEntity<ElectiveSlot> createSlot(@RequestBody ElectiveSlot slot) {
        return new ResponseEntity<>(electiveSlotService.createElectiveSlot(slot), HttpStatus.CREATED);
    }
    
    @PutMapping("/{slotId}/assign/{courseId}")
    public ResponseEntity<ElectiveSlot> assignCourse(@PathVariable String slotId, @PathVariable String courseId) {
        try {
            return ResponseEntity.ok(electiveSlotService.assignCourseToSlot(slotId, courseId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}