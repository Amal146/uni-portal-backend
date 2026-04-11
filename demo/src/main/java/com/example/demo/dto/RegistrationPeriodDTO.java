package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationPeriodDTO {

    private String id;
    private String semesterId;
    private String type;
    private LocalDate openDate;
    private LocalDate closeDate;
    private LocalDate deregDeadline;
    private String status;
}
