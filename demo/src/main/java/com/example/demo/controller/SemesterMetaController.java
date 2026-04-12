package com.example.demo.controller;

import com.example.demo.model.SemesterMeta;
import com.example.demo.service.SemesterMetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/semester-metas")
@RequiredArgsConstructor
public class SemesterMetaController {
    private final SemesterMetaService semesterMetaService;

    @GetMapping
    public ResponseEntity<List<SemesterMeta>> getAllSemesterMetas() {
        return ResponseEntity.ok(semesterMetaService.getAllSemesterMetas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SemesterMeta> getSemesterMetaById(@PathVariable String id) {
        return ResponseEntity.ok(semesterMetaService.getSemesterMetaById(id));
    }

    @PostMapping
    public ResponseEntity<SemesterMeta> createSemesterMeta(@RequestBody SemesterMeta semesterMeta) {
        return new ResponseEntity<>(semesterMetaService.createSemesterMeta(semesterMeta), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SemesterMeta> updateSemesterMeta(@PathVariable String id, @RequestBody SemesterMeta semesterMeta) {
        return ResponseEntity.ok(semesterMetaService.updateSemesterMeta(id, semesterMeta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemesterMeta(@PathVariable String id) {
        semesterMetaService.deleteSemesterMeta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/season/{season}")
    public ResponseEntity<List<SemesterMeta>> getSemesterMetasBySeason(@PathVariable SemesterMeta.Season season) {
        return ResponseEntity.ok(semesterMetaService.getSemesterMetasBySeason(season));
    }

    @GetMapping("/year/{calYear}")
    public ResponseEntity<List<SemesterMeta>> getSemesterMetasByCalYear(@PathVariable Integer calYear) {
        return ResponseEntity.ok(semesterMetaService.getSemesterMetasByCalYear(calYear));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<SemesterMeta>> getSemesterMetasByStatus(@PathVariable SemesterMeta.SemesterStatus status) {
        return ResponseEntity.ok(semesterMetaService.getSemesterMetasByStatus(status));
    }

    @GetMapping("/lookup")
    public ResponseEntity<SemesterMeta> getSemesterMetaByLabelAndCalYear(
            @RequestParam String label, @RequestParam Integer calYear) {
        return ResponseEntity.ok(semesterMetaService.getSemesterMetaByLabelAndCalYear(label, calYear));
    }
}