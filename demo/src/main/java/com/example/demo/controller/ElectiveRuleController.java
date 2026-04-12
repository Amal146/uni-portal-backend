package com.example.demo.controller;

import com.example.demo.model.ElectiveRule;
import com.example.demo.service.ElectiveRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elective-rules")
@RequiredArgsConstructor
public class ElectiveRuleController {
    private final ElectiveRuleService electiveRuleService;

    @GetMapping
    public ResponseEntity<List<ElectiveRule>> getAllElectiveRules() {
        return ResponseEntity.ok(electiveRuleService.getAllElectiveRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectiveRule> getElectiveRuleById(@PathVariable String id) {
        return ResponseEntity.ok(electiveRuleService.getElectiveRuleById(id));
    }

    @PostMapping
    public ResponseEntity<ElectiveRule> createElectiveRule(@RequestBody ElectiveRule rule) {
        return new ResponseEntity<>(electiveRuleService.createElectiveRule(rule), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectiveRule> updateElectiveRule(@PathVariable String id, @RequestBody ElectiveRule rule) {
        return ResponseEntity.ok(electiveRuleService.updateElectiveRule(id, rule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElectiveRule(@PathVariable String id) {
        electiveRuleService.deleteElectiveRule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<ElectiveRule>> getRulesByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(electiveRuleService.getRulesByProgrammeId(programmeId));
    }

    @GetMapping("/programme/{programmeId}/type/{type}")
    public ResponseEntity<List<ElectiveRule>> getRulesByProgrammeIdAndType(
            @PathVariable String programmeId, @PathVariable ElectiveRule.ElectiveType type) {
        return ResponseEntity.ok(electiveRuleService.getRulesByProgrammeIdAndType(programmeId, type));
    }
}