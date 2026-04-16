package com.example.demo.controller;

import com.example.demo.dto.CourseDTO;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable String id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }
    
    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        CourseDTO created = courseService.createCourse(courseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable String id, @RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.updateCourse(id, courseDTO));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/module/{moduleId}")
    public ResponseEntity<List<CourseDTO>> getCoursesByModuleId(@PathVariable String moduleId) {
        return ResponseEntity.ok(courseService.getCoursesByModuleId(moduleId));
    }
    
    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<CourseDTO>> getCoursesByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(courseService.getCoursesByProgrammeId(programmeId));
    }
    
    @GetMapping("/type/{type}")
    public ResponseEntity<List<CourseDTO>> getCoursesByType(@PathVariable Course.CourseType type) {
        return ResponseEntity.ok(courseService.getCoursesByType(type));
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<CourseDTO>> searchCourses(@RequestParam String keyword) {
        return ResponseEntity.ok(courseService.searchCourses(keyword));
    }
}