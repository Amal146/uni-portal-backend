package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exam")
public class Exam {
    
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExamType type;
    
    private Integer durationMinutes;
    
    private LocalDate date;
    
    private LocalTime startTime;
    
    private String room;
    
    public enum ExamType {
        written, oral, project
    }
}