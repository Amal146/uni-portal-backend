package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Registration;

import lombok.AllArgsConstructor;


// RegistrationDTO with flat fields
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
    private String id;
    private String studentId;
    private String courseId;
    private String registrationPeriodId;
    private Integer seatsAvailable;
    private Integer seatsTotal;
    private String prerequisites;
    private Boolean prereqsMet;
    private String status;
    
    // Static method to convert from Entity to DTO
    public static RegistrationDTO fromEntity(Registration registration) {
        if (registration == null) return null;
        
        RegistrationDTO dto = new RegistrationDTO();
        dto.setId(registration.getId());
        dto.setStudentId(registration.getStudent() != null ? registration.getStudent().getId() : null);
        dto.setCourseId(registration.getCourse() != null ? registration.getCourse().getId() : null);
        dto.setRegistrationPeriodId(registration.getRegistrationPeriod() != null ? registration.getRegistrationPeriod().getId() : null);
        dto.setSeatsAvailable(registration.getSeatsAvailable());
        dto.setSeatsTotal(registration.getSeatsTotal());
        dto.setPrerequisites(registration.getPrerequisites());
        dto.setPrereqsMet(registration.getPrereqsMet());
        dto.setStatus(registration.getStatus() != null ? registration.getStatus().name() : null);
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<RegistrationDTO> fromEntities(List<Registration> registrations) {
        if (registrations == null) return new ArrayList<>();
        List<RegistrationDTO> dtos = new ArrayList<>();
        for (Registration registration : registrations) {
            dtos.add(fromEntity(registration));
        }
        return dtos;
    }
}
