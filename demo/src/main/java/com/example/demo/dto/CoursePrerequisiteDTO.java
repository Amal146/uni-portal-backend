package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.CoursePrerequisite;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursePrerequisiteDTO {
    private String id;
    private String courseId;
    private String requiredCourseId;
    private String programmeId;
    
    // Optional: Include course details for better context
    private String courseName;
    private String requiredCourseName;
    private String programmeName;
    
    // Static method to convert from Entity to DTO
    public static CoursePrerequisiteDTO fromEntity(CoursePrerequisite prerequisite) {
        if (prerequisite == null) return null;
        
        CoursePrerequisiteDTO dto = new CoursePrerequisiteDTO();
        dto.setId(prerequisite.getId());
        
        if (prerequisite.getCourse() != null) {
            dto.setCourseId(prerequisite.getCourse().getId());
            dto.setCourseName(prerequisite.getCourse().getName());
        }
        
        if (prerequisite.getRequiredCourse() != null) {
            dto.setRequiredCourseId(prerequisite.getRequiredCourse().getId());
            dto.setRequiredCourseName(prerequisite.getRequiredCourse().getName());
        }
        
        if (prerequisite.getProgramme() != null) {
            dto.setProgrammeId(prerequisite.getProgramme().getId());
            dto.setProgrammeName(prerequisite.getProgramme().getName());
        }
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<CoursePrerequisiteDTO> fromEntities(List<CoursePrerequisite> prerequisites) {
        if (prerequisites == null) return new ArrayList<>();
        List<CoursePrerequisiteDTO> dtos = new ArrayList<>();
        for (CoursePrerequisite prerequisite : prerequisites) {
            dtos.add(fromEntity(prerequisite));
        }
        return dtos;
    }
}