package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "elective_substitution_rule")
public class ElectiveSubstitutionRule {
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "elective_rule_id", nullable = false)
    private ElectiveRule electiveRule;
    
    @ManyToOne
    @JoinColumn(name = "programme_id", nullable = false)
    private Programme programme;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubstituteType substituteType;
    
    private Integer maxEcts;
    
    private Integer maxCourses;
    
    public enum SubstituteType {
        cross_programme, core_elective
    }
}