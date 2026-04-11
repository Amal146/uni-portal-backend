package com.example.demo.dto;

import java.time.LocalDate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {

    private String id;
    private String courseId;
    private String semesterId;
    private LocalDate date;
    private String dayOfWeek;
    private String timeSlot;
    private String room;
}