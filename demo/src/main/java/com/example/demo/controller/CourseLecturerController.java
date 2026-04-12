package com.example.demo.controller;

import com.example.demo.model.CourseLecturer;
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
    public ResponseEntity<List<CourseLecturer>> getAllCourseLecturers() {
        return ResponseEntity.ok(courseLecturerService.getAllCourseLecturers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseLecturer> getCourseLecturerById(@PathVariable String id) {
        return ResponseEntity.ok(courseLecturerService.getCourseLecturerById(id));
    }

    @PostMapping
    public ResponseEntity<CourseLecturer> createCourseLecturer(@RequestBody CourseLecturer courseLecturer) {
        return new ResponseEntity<>(courseLecturerService.createCourseLecturer(courseLecturer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseLecturer> updateCourseLecturer(@PathVariable String id, @RequestBody CourseLecturer courseLecturer) {
        return ResponseEntity.ok(courseLecturerService.updateCourseLecturer(id, courseLecturer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseLecturer(@PathVariable String id) {
        courseLecturerService.deleteCourseLecturer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<CourseLecturer>> getByCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(courseLecturerService.getByCourseId(courseId));
    }

    @GetMapping("/lecturer/{lecturerId}")
    public ResponseEntity<List<CourseLecturer>> getByLecturerId(@PathVariable String lecturerId) {
        return ResponseEntity.ok(courseLecturerService.getByLecturerId(lecturerId));
    }

    @GetMapping("/course/{courseId}/role/{role}")
    public ResponseEntity<List<CourseLecturer>> getByCourseIdAndRole(
            @PathVariable String courseId, @PathVariable CourseLecturer.Role role) {
        return ResponseEntity.ok(courseLecturerService.getByCourseIdAndRole(courseId, role));
    }
}