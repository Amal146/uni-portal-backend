package com.example.demo.controller;

import com.example.demo.dto.ProgrammeDTO;
import com.example.demo.service.ProgrammeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Updated ProgrammeController that returns DTOs
@RestController
@RequestMapping("/programmes")
@RequiredArgsConstructor
public class ProgrammeController {
    private final ProgrammeService programmeService;

    @GetMapping
    public ResponseEntity<List<ProgrammeDTO>> getAllProgrammes() {
        return ResponseEntity.ok(programmeService.getAllProgrammes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgrammeDTO> getProgrammeById(@PathVariable String id) {
        return ResponseEntity.ok(programmeService.getProgrammeById(id));
    }

    @PostMapping
    public ResponseEntity<ProgrammeDTO> createProgramme(@RequestBody ProgrammeDTO programme) {
        return new ResponseEntity<>(programmeService.createProgramme(programme), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgrammeDTO> updateProgramme(@PathVariable String id, @RequestBody ProgrammeDTO programme) {
        return ResponseEntity.ok(programmeService.updateProgramme(id, programme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramme(@PathVariable String id) {
        programmeService.deleteProgramme(id);
        return ResponseEntity.noContent().build();
    }
}