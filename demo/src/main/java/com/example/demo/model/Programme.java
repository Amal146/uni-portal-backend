package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "programme")
public class Programme {
    @Id
    private String id;
    
    private String name;
    private String shortName;
    
    @Enumerated(EnumType.STRING)
    private Degree degree;
    
    private Integer totalEcts;
    private Integer standardSems;
    
    @Column(name = "valid_from")
    private LocalDate validFrom;
    
    private Integer thesisEcts;
    private Integer thesisMinEcts;
    
    @OneToMany(mappedBy = "programme", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Module> modules = new ArrayList<>();
    
    @OneToMany(mappedBy = "programme", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ElectiveRule> electiveRules = new ArrayList<>();
    
    @OneToMany(mappedBy = "programme", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ThesisPrerequisite> thesisPrerequisites = new ArrayList<>();
    
    public enum Degree {
        Bachelor, Master, PhD
    }


}
