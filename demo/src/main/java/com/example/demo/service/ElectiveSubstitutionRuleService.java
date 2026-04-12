package com.example.demo.service;

import com.example.demo.model.ElectiveSubstitutionRule;
import com.example.demo.repository.ElectiveSubstitutionRuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ElectiveSubstitutionRuleService {
    private final ElectiveSubstitutionRuleRepository substitutionRuleRepository;

    public List<ElectiveSubstitutionRule> getAllSubstitutionRules() {
        return substitutionRuleRepository.findAll();
    }

    public ElectiveSubstitutionRule getSubstitutionRuleById(String id) {
        return substitutionRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ElectiveSubstitutionRule not found with id: " + id));
    }

    @Transactional
    public ElectiveSubstitutionRule createSubstitutionRule(ElectiveSubstitutionRule rule) {
        if (rule.getId() == null) {
            rule.setId(UUID.randomUUID().toString());
        }
        return substitutionRuleRepository.save(rule);
    }

    @Transactional
    public ElectiveSubstitutionRule updateSubstitutionRule(String id, ElectiveSubstitutionRule ruleDetails) {
        ElectiveSubstitutionRule rule = getSubstitutionRuleById(id);
        rule.setElectiveRule(ruleDetails.getElectiveRule());
        rule.setProgramme(ruleDetails.getProgramme());
        rule.setSubstituteType(ruleDetails.getSubstituteType());
        rule.setMaxEcts(ruleDetails.getMaxEcts());
        rule.setMaxCourses(ruleDetails.getMaxCourses());
        return substitutionRuleRepository.save(rule);
    }

    @Transactional
    public void deleteSubstitutionRule(String id) {
        substitutionRuleRepository.deleteById(id);
    }

    public List<ElectiveSubstitutionRule> getRulesByElectiveRuleId(String electiveRuleId) {
        return substitutionRuleRepository.findByElectiveRuleId(electiveRuleId);
    }

    public List<ElectiveSubstitutionRule> getRulesByProgrammeId(String programmeId) {
        return substitutionRuleRepository.findByProgrammeId(programmeId);
    }
}