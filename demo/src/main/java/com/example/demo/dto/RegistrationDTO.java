package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {

    private String id;
    private String studentId;
    private String courseId;
    private String registrationPeriodId;
    private Integer seatsAvailable;
    private Integer seatsTotal;
    private List<String> prerequisites;
    private Boolean prereqsMet;
    private String status;
}