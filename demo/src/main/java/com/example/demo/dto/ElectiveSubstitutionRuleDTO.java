package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.ElectiveSubstitutionRule;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectiveSubstitutionRuleDTO {
    private String id;
    private String electiveRuleId;
    private String programmeId;
    private String substituteType;
    private Integer maxEcts;
    private Integer maxCourses;
    
    // Static method to convert from Entity to DTO
    public static ElectiveSubstitutionRuleDTO fromEntity(ElectiveSubstitutionRule rule) {
        if (rule == null) return null;
        
        ElectiveSubstitutionRuleDTO dto = new ElectiveSubstitutionRuleDTO();
        dto.setId(rule.getId());
        dto.setElectiveRuleId(rule.getElectiveRule() != null ? rule.getElectiveRule().getId() : null);
        dto.setProgrammeId(rule.getProgramme() != null ? rule.getProgramme().getId() : null);
        dto.setSubstituteType(rule.getSubstituteType() != null ? rule.getSubstituteType().name() : null);
        dto.setMaxEcts(rule.getMaxEcts());
        dto.setMaxCourses(rule.getMaxCourses());
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<ElectiveSubstitutionRuleDTO> fromEntities(List<ElectiveSubstitutionRule> rules) {
        if (rules == null) return new ArrayList<>();
        List<ElectiveSubstitutionRuleDTO> dtos = new ArrayList<>();
        for (ElectiveSubstitutionRule rule : rules) {
            dtos.add(fromEntity(rule));
        }
        return dtos;
    }
}
