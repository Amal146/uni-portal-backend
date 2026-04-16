package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.RegistrationPeriod;

import lombok.AllArgsConstructor;
// RegistrationPeriodDTO with flat fields
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationPeriodDTO {
    private String id;
    private String semesterId;
    private String type;
    private LocalDate openDate;
    private LocalDate closeDate;
    private LocalDate deregDeadline;
    private String status;
    
    // Static method to convert from Entity to DTO
    public static RegistrationPeriodDTO fromEntity(RegistrationPeriod period) {
        if (period == null) return null;
        
        RegistrationPeriodDTO dto = new RegistrationPeriodDTO();
        dto.setId(period.getId());
        dto.setSemesterId(period.getSemester() != null ? period.getSemester().getId() : null);
        dto.setType(period.getType() != null ? period.getType().name() : null);
        dto.setOpenDate(period.getOpenDate());
        dto.setCloseDate(period.getCloseDate());
        dto.setDeregDeadline(period.getDeregDeadline());
        dto.setStatus(period.getStatus() != null ? period.getStatus().name() : null);
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<RegistrationPeriodDTO> fromEntities(List<RegistrationPeriod> periods) {
        if (periods == null) return new ArrayList<>();
        List<RegistrationPeriodDTO> dtos = new ArrayList<>();
        for (RegistrationPeriod period : periods) {
            dtos.add(fromEntity(period));
        }
        return dtos;
    }
}
