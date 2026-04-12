package com.example.demo.controller;

import com.example.demo.model.ElectiveSlot;
import com.example.demo.service.ElectiveSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elective-slots")
@RequiredArgsConstructor
public class ElectiveSlotController {
    private final ElectiveSlotService electiveSlotService;

    @GetMapping
    public ResponseEntity<List<ElectiveSlot>> getAllElectiveSlots() {
        return ResponseEntity.ok(electiveSlotService.getAllElectiveSlots());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectiveSlot> getElectiveSlotById(@PathVariable String id) {
        return ResponseEntity.ok(electiveSlotService.getElectiveSlotById(id));
    }

    @PostMapping
    public ResponseEntity<ElectiveSlot> createElectiveSlot(@RequestBody ElectiveSlot slot) {
        return new ResponseEntity<>(electiveSlotService.createElectiveSlot(slot), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectiveSlot> updateElectiveSlot(@PathVariable String id, @RequestBody ElectiveSlot slot) {
        return ResponseEntity.ok(electiveSlotService.updateElectiveSlot(id, slot));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElectiveSlot(@PathVariable String id) {
        electiveSlotService.deleteElectiveSlot(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ElectiveSlot>> getSlotsByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(electiveSlotService.getSlotsByStudentId(studentId));
    }

    @GetMapping("/student/{studentId}/type/{type}")
    public ResponseEntity<List<ElectiveSlot>> getSlotsByStudentIdAndType(
            @PathVariable String studentId, @PathVariable ElectiveSlot.ElectiveType type) {
        return ResponseEntity.ok(electiveSlotService.getSlotsByStudentIdAndType(studentId, type));
    }

    @GetMapping("/student/{studentId}/status/{status}")
    public ResponseEntity<List<ElectiveSlot>> getSlotsByStudentIdAndStatus(
            @PathVariable String studentId, @PathVariable ElectiveSlot.ElectiveStatus status) {
        return ResponseEntity.ok(electiveSlotService.getSlotsByStudentIdAndStatus(studentId, status));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<ElectiveSlot>> getSlotsBySelectedCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(electiveSlotService.getSlotsBySelectedCourseId(courseId));
    }
}