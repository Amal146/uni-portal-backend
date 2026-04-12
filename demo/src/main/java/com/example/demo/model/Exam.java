package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    
    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;
    
    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = false)
    private SemesterMeta semester;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExamType type;
    
    @Column(nullable = false)
    private LocalDate date;
    
    private String time;
    
    private Integer duration;
    
    private String room;
    
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExamRegistration> examRegistrations = new ArrayList<>();
    
    public enum ExamType {
        written, oral, project, presentation
    }
}