package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.CourseLecturer;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseLecturerDTO {
    private String id;
    private String courseId;
    private String lecturerId;
    private String role;
    
    // Static method to convert from Entity to DTO
    public static CourseLecturerDTO fromEntity(CourseLecturer courseLecturer) {
        if (courseLecturer == null) return null;
        
        CourseLecturerDTO dto = new CourseLecturerDTO();
        dto.setId(courseLecturer.getId());
        dto.setCourseId(courseLecturer.getCourse() != null ? courseLecturer.getCourse().getId() : null);
        dto.setLecturerId(courseLecturer.getLecturer() != null ? courseLecturer.getLecturer().getId() : null);
        dto.setRole(courseLecturer.getRole() != null ? courseLecturer.getRole().name() : null);
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<CourseLecturerDTO> fromEntities(List<CourseLecturer> courseLecturers) {
        if (courseLecturers == null) return new ArrayList<>();
        List<CourseLecturerDTO> dtos = new ArrayList<>();
        for (CourseLecturer courseLecturer : courseLecturers) {
            dtos.add(fromEntity(courseLecturer));
        }
        return dtos;
    }
}