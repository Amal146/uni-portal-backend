package com.example.demo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.demo.model.Course.CourseType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private String id;
    private String courseNumber;
    private String name;
    private String shortName;
    private CourseType type;
    private Boolean thesisPrereq;
    private String language;
    private String moduleId;
    private String moduleName;
    private String moodleUrl;
    private String description;
    private String category;
    private String season;
    
    // Additional statistics
    private Integer totalEnrollments;
    private Integer totalLecturers;
    private Integer totalSessions;
    private Integer capacity;
    private Integer availableSeats;
}