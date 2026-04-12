package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String id, @RequestBody Course course) {
        return ResponseEntity.ok(courseService.updateCourse(id, course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/module/{moduleId}")
    public ResponseEntity<List<Course>> getCoursesByModuleId(@PathVariable String moduleId) {
        return ResponseEntity.ok(courseService.getCoursesByModuleId(moduleId));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Course>> getCoursesByType(@PathVariable Course.CourseType type) {
        return ResponseEntity.ok(courseService.getCoursesByType(type));
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<Course>> getCoursesByLanguage(@PathVariable String language) {
        return ResponseEntity.ok(courseService.getCoursesByLanguage(language));
    }

    @GetMapping("/number/{courseNumber}")
    public ResponseEntity<Course> getCourseByCourseNumber(@PathVariable String courseNumber) {
        return ResponseEntity.ok(courseService.getCourseByCourseNumber(courseNumber));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Course>> searchCourses(@RequestParam String keyword) {
        return ResponseEntity.ok(courseService.searchCourses(keyword));
    }
}