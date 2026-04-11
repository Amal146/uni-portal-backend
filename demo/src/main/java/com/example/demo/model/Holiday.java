package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "holiday")
public class Holiday {
    @Id
    private String id;
    
    @Enumerated(EnumType.STRING)
    private HolidayType type;
    
    private String title;
    
    @Column(nullable = false)
    private LocalDate date;
    
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = false)
    private SemesterMeta semester;
    
    private LocalDate time;
    private String room;
    private String courseId;
    private String examId;
    
    public enum HolidayType {
        holiday
    }
}
