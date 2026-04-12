package com.example.demo.controller;

import com.example.demo.model.ThesisPrerequisite;
import com.example.demo.service.ThesisPrerequisiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thesis-prerequisites")
@RequiredArgsConstructor
public class ThesisPrerequisiteController {
    private final ThesisPrerequisiteService thesisPrerequisiteService;

    @GetMapping
    public ResponseEntity<List<ThesisPrerequisite>> getAllThesisPrerequisites() {
        return ResponseEntity.ok(thesisPrerequisiteService.getAllThesisPrerequisites());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThesisPrerequisite> getThesisPrerequisiteById(@PathVariable String id) {
        return ResponseEntity.ok(thesisPrerequisiteService.getThesisPrerequisiteById(id));
    }

    @PostMapping
    public ResponseEntity<ThesisPrerequisite> createThesisPrerequisite(@RequestBody ThesisPrerequisite prerequisite) {
        return new ResponseEntity<>(thesisPrerequisiteService.createThesisPrerequisite(prerequisite), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThesisPrerequisite> updateThesisPrerequisite(@PathVariable String id, @RequestBody ThesisPrerequisite prerequisite) {
        return ResponseEntity.ok(thesisPrerequisiteService.updateThesisPrerequisite(id, prerequisite));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThesisPrerequisite(@PathVariable String id) {
        thesisPrerequisiteService.deleteThesisPrerequisite(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<ThesisPrerequisite>> getPrerequisitesByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(thesisPrerequisiteService.getPrerequisitesByProgrammeId(programmeId));
    }

    @GetMapping("/module/{moduleId}")
    public ResponseEntity<List<ThesisPrerequisite>> getPrerequisitesByModuleId(@PathVariable String moduleId) {
        return ResponseEntity.ok(thesisPrerequisiteService.getPrerequisitesByModuleId(moduleId));
    }
}