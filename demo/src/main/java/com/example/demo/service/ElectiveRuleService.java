package com.example.demo.service;

import com.example.demo.model.ElectiveRule;
import com.example.demo.repository.ElectiveRuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ElectiveRuleService {
    private final ElectiveRuleRepository electiveRuleRepository;

    public List<ElectiveRule> getAllElectiveRules() {
        return electiveRuleRepository.findAll();
    }

    public ElectiveRule getElectiveRuleById(String id) {
        return electiveRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ElectiveRule not found with id: " + id));
    }

    @Transactional
    public ElectiveRule createElectiveRule(ElectiveRule electiveRule) {
        if (electiveRule.getId() == null) {
            electiveRule.setId(UUID.randomUUID().toString());
        }
        return electiveRuleRepository.save(electiveRule);
    }

    @Transactional
    public ElectiveRule updateElectiveRule(String id, ElectiveRule ruleDetails) {
        ElectiveRule rule = getElectiveRuleById(id);
        rule.setProgramme(ruleDetails.getProgramme());
        rule.setType(ruleDetails.getType());
        rule.setTotalSlots(ruleDetails.getTotalSlots());
        rule.setEctsPerSlot(ruleDetails.getEctsPerSlot());
        rule.setRequiredEcts(ruleDetails.getRequiredEcts());
        rule.setMaxSubstituteEcts(ruleDetails.getMaxSubstituteEcts());
        return electiveRuleRepository.save(rule);
    }

    @Transactional
    public void deleteElectiveRule(String id) {
        electiveRuleRepository.deleteById(id);
    }

    public List<ElectiveRule> getRulesByProgrammeId(String programmeId) {
        return electiveRuleRepository.findByProgrammeId(programmeId);
    }

    public List<ElectiveRule> getRulesByProgrammeIdAndType(String programmeId, ElectiveRule.ElectiveType type) {
        return electiveRuleRepository.findByProgrammeIdAndType(programmeId, type);
    }
}