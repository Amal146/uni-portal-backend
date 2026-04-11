package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "elective_rule")
public class ElectiveRule {
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "programme_id", nullable = false)
    private Programme programme;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ElectiveType type;
    
    private Integer totalSlots;
    
    private Integer ectsPerSlot;
    
    private Integer requiredEcts;
    
    private Integer maxSubstituteEcts;
    
    @OneToMany(mappedBy = "electiveRule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ElectiveSubstitutionRule> substitutionRules = new ArrayList<>();
    
    public enum ElectiveType {
        core_elective, cross_faculty
    }
    
    public void addSubstitutionRule(ElectiveSubstitutionRule rule) {
        substitutionRules.add(rule);
        rule.setElectiveRule(this);
    }
    
    public void removeSubstitutionRule(ElectiveSubstitutionRule rule) {
        substitutionRules.remove(rule);
        rule.setElectiveRule(null);
    }
}