package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private String id;
    private String userId;
    private String matricNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String programmeId;
    private String startSemester;
    private String startSeason;
    private Integer startYear;
    private Integer maxYears;
    private Integer minEctsPerYear;
    private String status;
    private String role;
}
