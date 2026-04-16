package com.example.demo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Enrollment;
// EnrollmentDTO with flat fields
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDTO {
    private String id;
    private String studentId;
    private String courseId;
    private String semesterId;
    private Integer plannedSlot;
    private String status;
    private Integer grade;
    private LocalDateTime enrolledAt;
    
    // Static method to convert from Entity to DTO
    public static EnrollmentDTO fromEntity(Enrollment enrollment) {
        if (enrollment == null) return null;
        
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(enrollment.getId());
        dto.setStudentId(enrollment.getStudent() != null ? enrollment.getStudent().getId() : null);
        dto.setCourseId(enrollment.getCourse() != null ? enrollment.getCourse().getId() : null);
        dto.setSemesterId(enrollment.getSemester() != null ? enrollment.getSemester().getId() : null);
        dto.setPlannedSlot(enrollment.getPlannedSlot());
        dto.setStatus(enrollment.getStatus() != null ? enrollment.getStatus().name() : null);
        dto.setGrade(enrollment.getGrade());
        dto.setEnrolledAt(enrollment.getEnrolledAt());
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<EnrollmentDTO> fromEntities(List<Enrollment> enrollments) {
        if (enrollments == null) return new ArrayList<>();
        List<EnrollmentDTO> dtos = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            dtos.add(fromEntity(enrollment));
        }
        return dtos;
    }
}
