package com.example.demo.service;

import com.example.demo.dto.ElectiveSubstitutionRuleDTO;
import com.example.demo.model.ElectiveRule;
import com.example.demo.model.ElectiveSubstitutionRule;
import com.example.demo.model.Programme;
import com.example.demo.repository.ElectiveRuleRepository;
import com.example.demo.repository.ElectiveSubstitutionRuleRepository;
import com.example.demo.repository.ProgrammeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ElectiveSubstitutionRuleService {
    private final ElectiveSubstitutionRuleRepository substitutionRuleRepository;
    private final ElectiveRuleRepository electiveRuleRepository;
    private final ProgrammeRepository programmeRepository;

    public List<ElectiveSubstitutionRuleDTO> getAllSubstitutionRules() {
        return ElectiveSubstitutionRuleDTO.fromEntities(substitutionRuleRepository.findAll());
    }

    public ElectiveSubstitutionRuleDTO getSubstitutionRuleById(String id) {
        ElectiveSubstitutionRule rule = substitutionRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ElectiveSubstitutionRule not found with id: " + id));
        return ElectiveSubstitutionRuleDTO.fromEntity(rule);
    }

    @Transactional
    public ElectiveSubstitutionRuleDTO createSubstitutionRule(ElectiveSubstitutionRuleDTO ruleDTO) {
        ElectiveSubstitutionRule rule = convertToEntity(ruleDTO);
        if (rule.getId() == null) {
            rule.setId(java.util.UUID.randomUUID().toString());
        }
        ElectiveSubstitutionRule saved = substitutionRuleRepository.save(rule);
        return ElectiveSubstitutionRuleDTO.fromEntity(saved);
    }

    @Transactional
    public ElectiveSubstitutionRuleDTO updateSubstitutionRule(String id, ElectiveSubstitutionRuleDTO ruleDetailsDTO) {
        ElectiveSubstitutionRule rule = getSubstitutionRuleEntityById(id);
        updateSubstitutionRuleEntity(rule, ruleDetailsDTO);
        ElectiveSubstitutionRule updated = substitutionRuleRepository.save(rule);
        return ElectiveSubstitutionRuleDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteSubstitutionRule(String id) {
        substitutionRuleRepository.deleteById(id);
    }

    public List<ElectiveSubstitutionRuleDTO> getRulesByElectiveRuleId(String electiveRuleId) {
        return ElectiveSubstitutionRuleDTO.fromEntities(substitutionRuleRepository.findByElectiveRuleId(electiveRuleId));
    }

    public List<ElectiveSubstitutionRuleDTO> getRulesByProgrammeId(String programmeId) {
        return ElectiveSubstitutionRuleDTO.fromEntities(substitutionRuleRepository.findByProgrammeId(programmeId));
    }
    
    // Helper methods for internal use
    private ElectiveSubstitutionRule getSubstitutionRuleEntityById(String id) {
        return substitutionRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ElectiveSubstitutionRule not found with id: " + id));
    }
    
    private ElectiveSubstitutionRule convertToEntity(ElectiveSubstitutionRuleDTO dto) {
        ElectiveSubstitutionRule rule = new ElectiveSubstitutionRule();
        rule.setId(dto.getId());
        rule.setMaxEcts(dto.getMaxEcts());
        rule.setMaxCourses(dto.getMaxCourses());
        
        // Set ElectiveRule if electiveRuleId is provided
        if (dto.getElectiveRuleId() != null) {
            ElectiveRule electiveRule = electiveRuleRepository.findById(dto.getElectiveRuleId())
                    .orElseThrow(() -> new RuntimeException("ElectiveRule not found with id: " + dto.getElectiveRuleId()));
            rule.setElectiveRule(electiveRule);
        }
        
        // Set Programme if programmeId is provided
        if (dto.getProgrammeId() != null) {
            Programme programme = programmeRepository.findById(dto.getProgrammeId())
                    .orElseThrow(() -> new RuntimeException("Programme not found with id: " + dto.getProgrammeId()));
            rule.setProgramme(programme);
        }
        
        // Set SubstituteType if substituteType is provided
        if (dto.getSubstituteType() != null) {
            rule.setSubstituteType(ElectiveSubstitutionRule.SubstituteType.valueOf(dto.getSubstituteType()));
        }
        
        return rule;
    }
    
    private void updateSubstitutionRuleEntity(ElectiveSubstitutionRule rule, ElectiveSubstitutionRuleDTO dto) {
        rule.setMaxEcts(dto.getMaxEcts());
        rule.setMaxCourses(dto.getMaxCourses());
        
        // Update ElectiveRule if electiveRuleId is provided
        if (dto.getElectiveRuleId() != null) {
            ElectiveRule electiveRule = electiveRuleRepository.findById(dto.getElectiveRuleId())
                    .orElseThrow(() -> new RuntimeException("ElectiveRule not found with id: " + dto.getElectiveRuleId()));
            rule.setElectiveRule(electiveRule);
        }
        
        // Update Programme if programmeId is provided
        if (dto.getProgrammeId() != null) {
            Programme programme = programmeRepository.findById(dto.getProgrammeId())
                    .orElseThrow(() -> new RuntimeException("Programme not found with id: " + dto.getProgrammeId()));
            rule.setProgramme(programme);
        }
        
        // Update SubstituteType if substituteType is provided
        if (dto.getSubstituteType() != null) {
            rule.setSubstituteType(ElectiveSubstitutionRule.SubstituteType.valueOf(dto.getSubstituteType()));
        }
    }
}
