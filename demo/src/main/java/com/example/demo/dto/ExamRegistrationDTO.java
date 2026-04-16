package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.ExamRegistration;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamRegistrationDTO {
    private String id;
    private String studentId;
    private String examId;
    private String status;
    private LocalDateTime registeredAt;
    private Integer grade;
    private Integer attempt;
    
    // Static method to convert from Entity to DTO
    public static ExamRegistrationDTO fromEntity(ExamRegistration registration) {
        if (registration == null) return null;
        
        ExamRegistrationDTO dto = new ExamRegistrationDTO();
        dto.setId(registration.getId());
        dto.setStudentId(registration.getStudent() != null ? registration.getStudent().getId() : null);
        dto.setExamId(registration.getExam() != null ? registration.getExam().getId() : null);
        dto.setStatus(registration.getStatus() != null ? registration.getStatus().name() : null);
        dto.setRegisteredAt(registration.getRegisteredAt());
        dto.setGrade(registration.getGrade());
        dto.setAttempt(registration.getAttempt());
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<ExamRegistrationDTO> fromEntities(List<ExamRegistration> registrations) {
        if (registrations == null) return new ArrayList<>();
        List<ExamRegistrationDTO> dtos = new ArrayList<>();
        for (ExamRegistration registration : registrations) {
            dtos.add(fromEntity(registration));
        }
        return dtos;
    }
}
