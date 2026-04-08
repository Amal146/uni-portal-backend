package com.example.demo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.demo.model.Programme.Degree;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammeDTO {
    private String id;
    private String name;
    private Degree degree;
    private String faculty;
    private Integer minEctsPerYear;
    
    // Additional statistics
    private Long totalStudents;
    private Long totalModules;
    private Integer totalEcts;
}
