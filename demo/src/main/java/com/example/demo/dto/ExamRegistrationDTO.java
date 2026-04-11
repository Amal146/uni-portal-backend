package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamRegistrationDTO {

    private String id;
    private String studentId;
    private String examId;
    private String status;
    private LocalDateTime registeredAt;
    private Double grade;
    private Integer attempt;
}
