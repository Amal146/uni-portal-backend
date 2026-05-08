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
@Table(name = "course")
public class Course {
    @Id
    private String id;
    
    private String courseNumber;
    private String name;
    private String shortName;
    
    @Enumerated(EnumType.STRING)
    private CourseType type;
    
    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;
    
    @ManyToOne
    @JoinColumn(name = "programme_id", nullable = false)
    private Programme programme;
    
    private String language;
    
    @Enumerated(EnumType.STRING)
    private Season season;
    
    private String description;
    private String taughtUnits;
    private String privateStudyTime;
    
    private String moodleUrl;
    
    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    private Lecturer coordinator;
    
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollments = new ArrayList<>();
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CourseLecturer> courseLecturers = new ArrayList<>();
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Schedule> schedules = new ArrayList<>();
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Registration> registrations = new ArrayList<>();
    
    public enum CourseType {
        lecture, seminar, exam, thesis
    }
    
    public enum Season {
        Winter, Summer, Both
    }
}