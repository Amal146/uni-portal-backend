package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Module;

import lombok.*;


// ModuleDTO with flat fields
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {
    private String id;
    private String name;
    private String shortName;
    private String programmeId;
    private String type;
    private Integer totalEcts;
    private String coordinatorId;
    
    // Static method to convert from Entity to DTO
    public static ModuleDTO fromEntity(Module module) {
        if (module == null) return null;
        
        ModuleDTO dto = new ModuleDTO();
        dto.setId(module.getId());
        dto.setName(module.getName());
        dto.setShortName(module.getShortName());
        dto.setProgrammeId(module.getProgramme() != null ? module.getProgramme().getId() : null);
        dto.setType(module.getType());
        dto.setTotalEcts(module.getTotalEcts());
        dto.setCoordinatorId(module.getCoordinator() != null ? module.getCoordinator().getId() : null);
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<ModuleDTO> fromEntities(List<Module> modules) {
        if (modules == null) return new ArrayList<>();
        List<ModuleDTO> dtos = new ArrayList<>();
        for (Module module : modules) {
            dtos.add(fromEntity(module));
        }
        return dtos;
    }
}
