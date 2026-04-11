package com.example.demo.service;

import com.example.demo.model.ElectiveRule;
import com.example.demo.repository.ElectiveRuleRepository;
import com.example.demo.repository.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ElectiveRuleService {
    
    @Autowired
    private ElectiveRuleRepository electiveRuleRepository;
    
    @Autowired
    private ProgrammeRepository programmeRepository;
    
    public List<ElectiveRule> getRulesByProgramme(String programmeId) {
        return electiveRuleRepository.findByProgrammeId(programmeId);
    }
    
    public List<ElectiveRule> getRulesByProgrammeAndType(String programmeId, ElectiveRule.ElectiveType type) {
        return electiveRuleRepository.findByProgrammeIdAndType(programmeId, type);
    }
    
    @Transactional
    public ElectiveRule createRule(ElectiveRule rule) {
        programmeRepository.findById(rule.getProgramme().getId())
            .orElseThrow(() -> new RuntimeException("Programme not found"));
        return electiveRuleRepository.save(rule);
    }
    
    @Transactional
    public ElectiveRule updateRule(String id, ElectiveRule ruleDetails) {
        ElectiveRule rule = electiveRuleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Rule not found"));
        
        if (ruleDetails.getTotalSlots() != null) rule.setTotalSlots(ruleDetails.getTotalSlots());
        if (ruleDetails.getEctsPerSlot() != null) rule.setEctsPerSlot(ruleDetails.getEctsPerSlot());
        if (ruleDetails.getRequiredEcts() != null) rule.setRequiredEcts(ruleDetails.getRequiredEcts());
        
        return electiveRuleRepository.save(rule);
    }
}