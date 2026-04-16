package com.example.demo.controller;

import com.example.demo.dto.ElectiveRuleDTO;
import com.example.demo.service.ElectiveRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elective-rules")
@RequiredArgsConstructor
public class ElectiveRuleController {
    private final ElectiveRuleService electiveRuleService;

    @GetMapping
    public ResponseEntity<List<ElectiveRuleDTO>> getAllElectiveRules() {
        return ResponseEntity.ok(electiveRuleService.getAllElectiveRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectiveRuleDTO> getElectiveRuleById(@PathVariable String id) {
        return ResponseEntity.ok(electiveRuleService.getElectiveRuleById(id));
    }

    @PostMapping
    public ResponseEntity<ElectiveRuleDTO> createElectiveRule(@RequestBody ElectiveRuleDTO rule) {
        return new ResponseEntity<>(electiveRuleService.createElectiveRule(rule), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectiveRuleDTO> updateElectiveRule(@PathVariable String id, @RequestBody ElectiveRuleDTO rule) {
        return ResponseEntity.ok(electiveRuleService.updateElectiveRule(id, rule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElectiveRule(@PathVariable String id) {
        electiveRuleService.deleteElectiveRule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<ElectiveRuleDTO>> getRulesByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(electiveRuleService.getRulesByProgrammeId(programmeId));
    }

    @GetMapping("/programme/{programmeId}/type/{type}")
    public ResponseEntity<List<ElectiveRuleDTO>> getRulesByProgrammeIdAndType(
            @PathVariable String programmeId, @PathVariable String type) {
        return ResponseEntity.ok(electiveRuleService.getRulesByProgrammeIdAndType(programmeId, type));
    }
}