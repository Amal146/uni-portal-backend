package com.example.demo.controller;

import com.example.demo.dto.ElectiveSlotDTO;
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
    public ResponseEntity<List<ElectiveSlotDTO>> getAllElectiveSlots() {
        return ResponseEntity.ok(electiveSlotService.getAllElectiveSlots());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectiveSlotDTO> getElectiveSlotById(@PathVariable String id) {
        return ResponseEntity.ok(electiveSlotService.getElectiveSlotById(id));
    }

    @PostMapping
    public ResponseEntity<ElectiveSlotDTO> createElectiveSlot(@RequestBody ElectiveSlotDTO slot) {
        return new ResponseEntity<>(electiveSlotService.createElectiveSlot(slot), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectiveSlotDTO> updateElectiveSlot(@PathVariable String id, @RequestBody ElectiveSlotDTO slot) {
        return ResponseEntity.ok(electiveSlotService.updateElectiveSlot(id, slot));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElectiveSlot(@PathVariable String id) {
        electiveSlotService.deleteElectiveSlot(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ElectiveSlotDTO>> getSlotsByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(electiveSlotService.getSlotsByStudentId(studentId));
    }

    @GetMapping("/student/{studentId}/type/{type}")
    public ResponseEntity<List<ElectiveSlotDTO>> getSlotsByStudentIdAndType(
            @PathVariable String studentId, @PathVariable String type) {
        return ResponseEntity.ok(electiveSlotService.getSlotsByStudentIdAndType(studentId, type));
    }


    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<ElectiveSlotDTO>> getSlotsBySelectedCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(electiveSlotService.getSlotsBySelectedCourseId(courseId));
    }
}
