package com.example.demo.dto;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.ElectiveSlot;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectiveSlotDTO {
    private String id;
    private String studentId;
    private String type;
    private String label;
    private Integer slotNumber;
    private Integer plannedSlot;
    private String plannedSemesterId;
    private String selectedCourseId;
    private String status;
    
    // Static method to convert from Entity to DTO
    public static ElectiveSlotDTO fromEntity(ElectiveSlot electiveSlot) {
        if (electiveSlot == null) return null;
        
        ElectiveSlotDTO dto = new ElectiveSlotDTO();
        dto.setId(electiveSlot.getId());
        dto.setStudentId(electiveSlot.getStudent() != null ? electiveSlot.getStudent().getId() : null);
        dto.setType(electiveSlot.getType() != null ? electiveSlot.getType().name() : null);
        dto.setLabel(electiveSlot.getLabel());
        dto.setSlotNumber(electiveSlot.getSlotNumber());
        dto.setPlannedSlot(electiveSlot.getPlannedSlot());
        dto.setPlannedSemesterId(electiveSlot.getPlannedSemester() != null ? electiveSlot.getPlannedSemester().getId() : null);
        dto.setSelectedCourseId(electiveSlot.getSelectedCourse() != null ? electiveSlot.getSelectedCourse().getId() : null);
        dto.setStatus(electiveSlot.getStatus() != null ? electiveSlot.getStatus().name() : null);
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<ElectiveSlotDTO> fromEntities(List<ElectiveSlot> electiveSlots) {
        if (electiveSlots == null) return new ArrayList<>();
        List<ElectiveSlotDTO> dtos = new ArrayList<>();
        for (ElectiveSlot electiveSlot : electiveSlots) {
            dtos.add(fromEntity(electiveSlot));
        }
        return dtos;
    }
}