package com.example.demo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.demo.model.Module.ModuleType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {
    private String id;
    private String moduleCode;
    private String name;
    private Integer ects;
    private ModuleType type;
    private Integer niveau;
    private Integer taughtUnitsPerSemester;
    private Integer privateStudyTime;
    private String programmeId;
    private String programmeName;
    private String moduleCoordinatorId;
    private String moduleCoordinatorName;
    private String examProcedure;
    private String requirements;
    private String content;
    private String learningOutcomes;
    private String literature;
    
    // Additional statistics
    private Integer totalCourses;
    private Integer totalEnrollments;
    private Double averageGrade;
}
