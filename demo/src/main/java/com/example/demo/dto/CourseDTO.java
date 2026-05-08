package com.example.demo.dto;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Course;

import lombok.*;

// Updated CourseDTO without Builder pattern
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private String id;
    private String courseNumber;
    private String name;
    private String shortName;
    private String type;
    private String moduleId;
    private String programmeId;
    private String language;
    private String season;
    private String description;
    private String taughtUnits;
    private String privateStudyTime;
    private String moodleUrl;
    private String coordinatorId;
    
    // Static method to convert from Course entity to DTO
    public static CourseDTO fromEntity(Course course) {
        if (course == null) return null;
        
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setCourseNumber(course.getCourseNumber());
        dto.setName(course.getName());
        dto.setShortName(course.getShortName());
        dto.setType(course.getType() != null ? course.getType().name() : null);
        dto.setModuleId(course.getModule() != null ? course.getModule().getId() : null);
        dto.setProgrammeId(course.getProgramme() != null ? course.getProgramme().getId() : null);
        dto.setLanguage(course.getLanguage());
        dto.setSeason(course.getSeason() != null ? course.getSeason().name() : null);
        dto.setDescription(course.getDescription());
        dto.setTaughtUnits(course.getTaughtUnits());
        dto.setPrivateStudyTime(course.getPrivateStudyTime());
        dto.setMoodleUrl(course.getMoodleUrl());
        dto.setCoordinatorId(course.getCoordinator() != null ? course.getCoordinator().getId() : null);
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<CourseDTO> fromEntities(List<Course> courses) {
        if (courses == null) return new ArrayList<>();
        List<CourseDTO> dtos = new ArrayList<>();
        for (Course course : courses) {
            dtos.add(fromEntity(course));
        }
        return dtos;
    }
}