package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.ThesisPrerequisite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ThesisPrerequisiteDTO with flat fields
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThesisPrerequisiteDTO {
    private String id;
    private String programmeId;
    private String moduleId;
    
    // Static method to convert from Entity to DTO
    public static ThesisPrerequisiteDTO fromEntity(ThesisPrerequisite prerequisite) {
        if (prerequisite == null) return null;
        
        ThesisPrerequisiteDTO dto = new ThesisPrerequisiteDTO();
        dto.setId(prerequisite.getId());
        dto.setProgrammeId(prerequisite.getProgramme() != null ? prerequisite.getProgramme().getId() : null);
        dto.setModuleId(prerequisite.getModule() != null ? prerequisite.getModule().getId() : null);
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<ThesisPrerequisiteDTO> fromEntities(List<ThesisPrerequisite> prerequisites) {
        if (prerequisites == null) return new ArrayList<>();
        List<ThesisPrerequisiteDTO> dtos = new ArrayList<>();
        for (ThesisPrerequisite prerequisite : prerequisites) {
            dtos.add(fromEntity(prerequisite));
        }
        return dtos;
    }
}
