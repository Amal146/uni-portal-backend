package com.example.demo.controller;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// Updated ScheduleController that returns DTOs
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<ScheduleDTO>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> getScheduleById(@PathVariable String id) {
        return ResponseEntity.ok(scheduleService.getScheduleById(id));
    }

    @PostMapping
    public ResponseEntity<ScheduleDTO> createSchedule(@RequestBody ScheduleDTO schedule) {
        return new ResponseEntity<>(scheduleService.createSchedule(schedule), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleDTO> updateSchedule(@PathVariable String id, @RequestBody ScheduleDTO schedule) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, schedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable String id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<ScheduleDTO>> getSchedulesByCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(scheduleService.getSchedulesByCourseId(courseId));
    }

    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<List<ScheduleDTO>> getSchedulesBySemesterId(@PathVariable String semesterId) {
        return ResponseEntity.ok(scheduleService.getSchedulesBySemesterId(semesterId));
    }

    @GetMapping("/between")
    public ResponseEntity<List<ScheduleDTO>> getSchedulesBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(scheduleService.getSchedulesBetweenDates(startDate, endDate));
    }
}