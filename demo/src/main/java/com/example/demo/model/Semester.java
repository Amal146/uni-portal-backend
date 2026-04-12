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
@Table(name = "semester")
public class Semester {
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
    private String status;
    
    public enum Season {
        Winter, Summer
    }
}















