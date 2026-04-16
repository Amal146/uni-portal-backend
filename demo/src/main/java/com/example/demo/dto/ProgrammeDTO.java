package com.example.demo.dto;



import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Programme;

// ProgrammeDTO with flat fields
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammeDTO {
    private String id;
    private String name;
    private String shortName;
    private String degree;
    private Integer totalEcts;
    private Integer standardSems;
    private LocalDate validFrom;
    private Integer thesisEcts;
    private Integer thesisMinEcts;
    
    // Static method to convert from Entity to DTO
    public static ProgrammeDTO fromEntity(Programme programme) {
        if (programme == null) return null;
        
        ProgrammeDTO dto = new ProgrammeDTO();
        dto.setId(programme.getId());
        dto.setName(programme.getName());
        dto.setShortName(programme.getShortName());
        dto.setDegree(programme.getDegree() != null ? programme.getDegree().name() : null);
        dto.setTotalEcts(programme.getTotalEcts());
        dto.setStandardSems(programme.getStandardSems());
        dto.setValidFrom(programme.getValidFrom());
        dto.setThesisEcts(programme.getThesisEcts());
        dto.setThesisMinEcts(programme.getThesisMinEcts());
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<ProgrammeDTO> fromEntities(List<Programme> programmes) {
        if (programmes == null) return new ArrayList<>();
        List<ProgrammeDTO> dtos = new ArrayList<>();
        for (Programme programme : programmes) {
            dtos.add(fromEntity(programme));
        }
        return dtos;
    }
}
