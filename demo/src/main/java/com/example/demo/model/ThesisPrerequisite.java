package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "thesis_prerequisite")
public class ThesisPrerequisite {
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "programme_id", nullable = false)
    private Programme programme;
    
    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;
}