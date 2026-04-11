package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectiveSubstitutionRuleDTO {

    private String id;
    private String electiveRuleId;
    private String programmeId;
    private String substituteType;
    private Integer maxEcts;
    private Integer maxCourses;
}
