package com.example.demo.controller;

import com.example.demo.dto.CourseLecturerDTO;
import com.example.demo.service.CourseLecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/course-lecturers")
@RequiredArgsConstructor
public class CourseLecturerController {
    private final CourseLecturerService courseLecturerService;

    @GetMapping
    public ResponseEntity<List<CourseLecturerDTO>> getAllCourseLecturers() {
        return ResponseEntity.ok(courseLecturerService.getAllCourseLecturers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseLecturerDTO> getCourseLecturerById(@PathVariable String id) {
        return ResponseEntity.ok(courseLecturerService.getCourseLecturerById(id));
    }

    @PostMapping
    public ResponseEntity<CourseLecturerDTO> createCourseLecturer(@RequestBody CourseLecturerDTO courseLecturerDTO) {
        return new ResponseEntity<>(courseLecturerService.createCourseLecturer(courseLecturerDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseLecturerDTO> updateCourseLecturer(@PathVariable String id, @RequestBody CourseLecturerDTO courseLecturerDTO) {
        return ResponseEntity.ok(courseLecturerService.updateCourseLecturer(id, courseLecturerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseLecturer(@PathVariable String id) {
        courseLecturerService.deleteCourseLecturer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<CourseLecturerDTO>> getByCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(courseLecturerService.getByCourseId(courseId));
    }

    @GetMapping("/lecturer/{lecturerId}")
    public ResponseEntity<List<CourseLecturerDTO>> getByLecturerId(@PathVariable String lecturerId) {
        return ResponseEntity.ok(courseLecturerService.getByLecturerId(lecturerId));
    }

    @GetMapping("/course/{courseId}/role/{role}")
    public ResponseEntity<List<CourseLecturerDTO>> getByCourseIdAndRole(
            @PathVariable String courseId, @PathVariable String role) {
        return ResponseEntity.ok(courseLecturerService.getByCourseIdAndRole(courseId, role));
    }
}