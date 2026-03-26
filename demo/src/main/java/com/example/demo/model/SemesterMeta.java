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
@Table(name = "semester_meta")
public class SemesterMeta {
    @Id
    private String id;
    
    private String name;
    private LocalDate start;
    private LocalDate end;
    private LocalDate examPeriodStart;
    private LocalDate examPeriodEnd;
}