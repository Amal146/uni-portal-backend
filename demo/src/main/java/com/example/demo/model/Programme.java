package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "programme")
public class Programme {
    @Id
    private String id;
    
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Degree degree;
    
    private String faculty;
    
    private Integer minEctsPerYear;
    
    public enum Degree {
        Bachelor, Master, PhD
    }
}
