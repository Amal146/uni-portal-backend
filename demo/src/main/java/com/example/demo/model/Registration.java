package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registration")
public class Registration {
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    
    @ManyToOne
    @JoinColumn(name = "registration_period_id", nullable = false)
    private RegistrationPeriod registrationPeriod;
    
    private Integer seatsAvailable;
    private Integer seatsTotal;
    
    @Column(columnDefinition = "TEXT")
    private String prerequisites;
    
    private Boolean prereqsMet;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RegistrationStatus status;
    
    public enum RegistrationStatus {
        eligible, full, registered, missing_prereq
    }
    
    @PrePersist
    protected void onCreate() {
        if (status == null) {
            status = RegistrationStatus.eligible;
        }
    }
}