package com.example.demo.dto;

import java.time.LocalDate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HolidayDTO {

    private String id;
    private String type;
    private String title;
    private LocalDate date;
    private String description;
    private String semesterId;
    private String time;
    private String room;
    private String courseId;
    private String examId;
}
