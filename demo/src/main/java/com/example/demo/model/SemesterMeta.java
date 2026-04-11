package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "semester_metas")
public class SemesterMeta {
    @Id
    private String id;
    
    private String name;
    private String shortLabel;
    private String label;
    
    @Enumerated(EnumType.STRING)
    private Season season;
    
    private Integer calYear;
    
    private LocalDate start;
    private LocalDate end;
    
    private LocalDate examPeriodStart;
    private LocalDate examPeriodEnd;
    
    @Enumerated(EnumType.STRING)
    private SemesterStatus status;
    
    public enum Season {
        Winter, Summer
    }
    
    public enum SemesterStatus {
        upcoming, current, completed
    }
}