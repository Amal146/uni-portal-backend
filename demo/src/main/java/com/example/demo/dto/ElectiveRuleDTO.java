package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.ElectiveRule;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectiveRuleDTO {
    private String id;
    private String programmeId;
    private String type;
    private Integer totalSlots;
    private Integer ectsPerSlot;
    private Integer requiredEcts;
    private Integer maxSubstituteEcts;
    
    // Static method to convert from Entity to DTO
    public static ElectiveRuleDTO fromEntity(ElectiveRule electiveRule) {
        if (electiveRule == null) return null;
        
        ElectiveRuleDTO dto = new ElectiveRuleDTO();
        dto.setId(electiveRule.getId());
        dto.setProgrammeId(electiveRule.getProgramme() != null ? electiveRule.getProgramme().getId() : null);
        dto.setType(electiveRule.getType() != null ? electiveRule.getType().name() : null);
        dto.setTotalSlots(electiveRule.getTotalSlots());
        dto.setEctsPerSlot(electiveRule.getEctsPerSlot());
        dto.setRequiredEcts(electiveRule.getRequiredEcts());
        dto.setMaxSubstituteEcts(electiveRule.getMaxSubstituteEcts());
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<ElectiveRuleDTO> fromEntities(List<ElectiveRule> electiveRules) {
        if (electiveRules == null) return new ArrayList<>();
        List<ElectiveRuleDTO> dtos = new ArrayList<>();
        for (ElectiveRule electiveRule : electiveRules) {
            dtos.add(fromEntity(electiveRule));
        }
        return dtos;
    }
}