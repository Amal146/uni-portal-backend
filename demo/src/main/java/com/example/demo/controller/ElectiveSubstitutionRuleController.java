package com.example.demo.controller;

import com.example.demo.model.ElectiveSubstitutionRule;
import com.example.demo.service.ElectiveSubstitutionRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elective-substitution-rules")
@RequiredArgsConstructor
public class ElectiveSubstitutionRuleController {
    private final ElectiveSubstitutionRuleService substitutionRuleService;

    @GetMapping
    public ResponseEntity<List<ElectiveSubstitutionRule>> getAllSubstitutionRules() {
        return ResponseEntity.ok(substitutionRuleService.getAllSubstitutionRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectiveSubstitutionRule> getSubstitutionRuleById(@PathVariable String id) {
        return ResponseEntity.ok(substitutionRuleService.getSubstitutionRuleById(id));
    }

    @PostMapping
    public ResponseEntity<ElectiveSubstitutionRule> createSubstitutionRule(@RequestBody ElectiveSubstitutionRule rule) {
        return new ResponseEntity<>(substitutionRuleService.createSubstitutionRule(rule), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectiveSubstitutionRule> updateSubstitutionRule(@PathVariable String id, @RequestBody ElectiveSubstitutionRule rule) {
        return ResponseEntity.ok(substitutionRuleService.updateSubstitutionRule(id, rule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubstitutionRule(@PathVariable String id) {
        substitutionRuleService.deleteSubstitutionRule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/elective-rule/{electiveRuleId}")
    public ResponseEntity<List<ElectiveSubstitutionRule>> getRulesByElectiveRuleId(@PathVariable String electiveRuleId) {
        return ResponseEntity.ok(substitutionRuleService.getRulesByElectiveRuleId(electiveRuleId));
    }

    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<ElectiveSubstitutionRule>> getRulesByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(substitutionRuleService.getRulesByProgrammeId(programmeId));
    }
}