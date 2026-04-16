package com.example.demo.controller;

import com.example.demo.dto.ElectiveSubstitutionRuleDTO;
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
    public ResponseEntity<List<ElectiveSubstitutionRuleDTO>> getAllSubstitutionRules() {
        return ResponseEntity.ok(substitutionRuleService.getAllSubstitutionRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectiveSubstitutionRuleDTO> getSubstitutionRuleById(@PathVariable String id) {
        return ResponseEntity.ok(substitutionRuleService.getSubstitutionRuleById(id));
    }

    @PostMapping
    public ResponseEntity<ElectiveSubstitutionRuleDTO> createSubstitutionRule(@RequestBody ElectiveSubstitutionRuleDTO rule) {
        return new ResponseEntity<>(substitutionRuleService.createSubstitutionRule(rule), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectiveSubstitutionRuleDTO> updateSubstitutionRule(@PathVariable String id, @RequestBody ElectiveSubstitutionRuleDTO rule) {
        return ResponseEntity.ok(substitutionRuleService.updateSubstitutionRule(id, rule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubstitutionRule(@PathVariable String id) {
        substitutionRuleService.deleteSubstitutionRule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/elective-rule/{electiveRuleId}")
    public ResponseEntity<List<ElectiveSubstitutionRuleDTO>> getRulesByElectiveRuleId(@PathVariable String electiveRuleId) {
        return ResponseEntity.ok(substitutionRuleService.getRulesByElectiveRuleId(electiveRuleId));
    }

    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<ElectiveSubstitutionRuleDTO>> getRulesByProgrammeId(@PathVariable String programmeId) {
        return ResponseEntity.ok(substitutionRuleService.getRulesByProgrammeId(programmeId));
    }
}