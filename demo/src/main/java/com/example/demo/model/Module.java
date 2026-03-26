package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "module")
public class Module {
    @Id
    private String id;
    
    private String moduleCode;
    private String name;
    private Integer ects;
    
    @Enumerated(EnumType.STRING)
    private ModuleType type;
    
    private Integer niveau;
    private Integer taughtUnitsPerSemester;
    private Integer privateStudyTime;
    
    @ManyToOne
    @JoinColumn(name = "programme_id")
    private Programme programme;
    
    @ManyToOne
    @JoinColumn(name = "module_coordinator_id")
    private Lecturer moduleCoordinator;
    
    private String examProcedure;
    private String requirements;
    private String content;
    private String learningOutcomes;
    private String literature;
    
    public enum ModuleType {
        compulsory, elective
    }
}