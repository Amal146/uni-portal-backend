package com.example.demo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.demo.model.Student.Season;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String id;
    private Integer matriculationNumber;
    private String firstName;
    private String lastName;
    private String programmeId;
    private String programmeName;
    private Season startSeason;
    private Integer startYear;
    private Integer maxYears;
    private Integer currentSemester;
    private Integer totalEarnedEcts;
    private Double averageGrade;
}
