package com.example.demo.dto;

import lombok.*;
import java.time.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SemesterDTO {

    private String id;
    private String name;
    private String shortLabel;
    private String label;
    private String season;
    private Integer calYear;
    private LocalDate start;
    private LocalDate end;
    private LocalDate examPeriodStart;
    private LocalDate examPeriodEnd;
    private String status;
}