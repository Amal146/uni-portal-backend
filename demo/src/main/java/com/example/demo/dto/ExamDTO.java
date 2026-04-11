package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamDTO {

    private String id;
    private String courseId;
    private String moduleId;
    private String semesterId;
    private String type;
    private LocalDate date;
    private String time;
    private Integer duration;
    private String room;
}