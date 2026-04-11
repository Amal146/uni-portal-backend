package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exam_registration", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "exam_id"}))
public class ExamRegistration {
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RegistrationStatus status;
    
    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;
    
    private Integer grade;
    
    private Integer attempt;
    
    public enum RegistrationStatus {
        registered, completed, failed, cancelled, no_show
    }
    
    @PrePersist
    protected void onCreate() {
        if (registeredAt == null) {
            registeredAt = LocalDateTime.now();
        }
        if (attempt == null) {
            attempt = 1;
        }
    }
}