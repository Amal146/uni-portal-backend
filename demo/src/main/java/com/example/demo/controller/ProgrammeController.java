package com.example.demo.controller;

import com.example.demo.model.Programme;
import com.example.demo.service.ProgrammeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programmes")
@RequiredArgsConstructor
public class ProgrammeController {
    private final ProgrammeService programmeService;

    @GetMapping
    public ResponseEntity<List<Programme>> getAllProgrammes() {
        return ResponseEntity.ok(programmeService.getAllProgrammes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Programme> getProgrammeById(@PathVariable String id) {
        return ResponseEntity.ok(programmeService.getProgrammeById(id));
    }

    @PostMapping
    public ResponseEntity<Programme> createProgramme(@RequestBody Programme programme) {
        return new ResponseEntity<>(programmeService.createProgramme(programme), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Programme> updateProgramme(@PathVariable String id, @RequestBody Programme programme) {
        return ResponseEntity.ok(programmeService.updateProgramme(id, programme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramme(@PathVariable String id) {
        programmeService.deleteProgramme(id);
        return ResponseEntity.noContent().build();
    }
}