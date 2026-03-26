package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    private String id;
    
    private Integer matriculationNumber;
    private String firstName;
    private String lastName;
    
    @ManyToOne
    @JoinColumn(name = "programme_id")
    private Programme programme;
    
    @Enumerated(EnumType.STRING)
    private Season startSeason;
    
    private Integer startYear;
    private Integer maxYears;
    
    public enum Season {
        Winter, Summer
    }
}