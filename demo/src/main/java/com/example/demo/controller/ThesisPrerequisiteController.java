package com.example.demo.controller;

import com.example.demo.dto.ThesisPrerequisiteDTO;
import com.example.demo.service.ThesisPrerequisiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



// Updated ThesisPrerequisiteController that returns DTOs
@RestController
@RequestMapping("/thesis-prerequisites")
@RequiredArgsConstructor
public class ThesisPrerequisiteController {
    private final ThesisPrerequisiteService thesisPrerequisiteService;

    @GetMapping
    public ResponseEntity<List<ThesisPrerequisiteDTO>> getAllThesisPrerequisites() {
        return ResponseEntity.ok(thesisPrerequisiteService.getAllThesisPrerequisites());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThesisPrerequisiteDTO> getThesisPrerequisiteById(@PathVariable String id) {
        return ResponseEntity.ok(thesisPrerequisiteService.getThesisPrerequisiteById(id));
    }

    @PostMapping
    public ResponseEntity<ThesisPrerequisiteDTO> createThesisPrerequisite(@RequestBody ThesisPrerequisiteDTO prerequisite) {
        return new ResponseEntity<>(thesisPrerequisiteService.createThesisPrerequisite(prerequisite), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThesisPrerequisiteDTO> updateThesisPrerequisite(@PathVariable String id, @RequestBody ThesisPrerequisiteDTO prerequisite) {
        return ResponseEntity.ok(thesisPrerequisiteService.updateThesisPrerequisite(id, prerequisite));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThesisPrerequisite(@PathVariable String id) {
        thesisPrerequisiteService.deleteThesisPrerequisite(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<ThesisPrerequisiteDTO>> getPrerequisitesByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(thesisPrerequisiteService.getPrerequisitesByProgrammeId(programmeId));
    }

    @GetMapping("/module/{moduleId}")
    public ResponseEntity<List<ThesisPrerequisiteDTO>> getPrerequisitesByModuleId(@PathVariable String moduleId) {
        return ResponseEntity.ok(thesisPrerequisiteService.getPrerequisitesByModuleId(moduleId));
    }
}
