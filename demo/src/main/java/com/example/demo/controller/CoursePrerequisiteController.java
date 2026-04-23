package com.example.demo.controller;

import com.example.demo.dto.CoursePrerequisiteDTO;
import com.example.demo.service.CoursePrerequisiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course-prerequisites")
@RequiredArgsConstructor
public class CoursePrerequisiteController {
    private final CoursePrerequisiteService prerequisiteService;
    
    @GetMapping
    public ResponseEntity<List<CoursePrerequisiteDTO>> getAllPrerequisites() {
        return ResponseEntity.ok(prerequisiteService.getAllPrerequisites());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CoursePrerequisiteDTO> getPrerequisiteById(@PathVariable String id) {
        return ResponseEntity.ok(prerequisiteService.getPrerequisiteById(id));
    }
    
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<CoursePrerequisiteDTO>> getPrerequisitesByCourseId(@PathVariable String courseId) {
        return ResponseEntity.ok(prerequisiteService.getPrerequisitesByCourseId(courseId));
    }
    
    @GetMapping("/course/{courseId}/programme/{programmeId}")
    public ResponseEntity<List<CoursePrerequisiteDTO>> getPrerequisitesByCourseAndProgramme(
            @PathVariable String courseId, 
            @PathVariable String programmeId) {
        return ResponseEntity.ok(prerequisiteService.getPrerequisitesByCourseIdAndProgrammeId(courseId, programmeId));
    }
    
    @GetMapping("/required/{requiredCourseId}")
    public ResponseEntity<List<CoursePrerequisiteDTO>> getCoursesRequiringPrerequisite(@PathVariable String requiredCourseId) {
        return ResponseEntity.ok(prerequisiteService.getCoursesRequiringPrerequisite(requiredCourseId));
    }
    
    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<CoursePrerequisiteDTO>> getPrerequisitesByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(prerequisiteService.getPrerequisitesByProgrammeId(programmeId));
    }
    
    @GetMapping("/exists")
    public ResponseEntity<Boolean> checkPrerequisiteExists(
            @RequestParam String courseId,
            @RequestParam String requiredCourseId,
            @RequestParam String programmeId) {
        return ResponseEntity.ok(prerequisiteService.checkPrerequisiteExists(courseId, requiredCourseId, programmeId));
    }
}