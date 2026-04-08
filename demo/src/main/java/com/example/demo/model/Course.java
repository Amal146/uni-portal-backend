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
    
    private Boolean thesisPrereq;
    private String language;
    
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;
    
    private String moodleUrl;
    private String description;
    private String category;
    private String season;
    
    
// Add relationship to enrollments
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollments = new ArrayList<>();
    
    // Add relationship to course lecturers
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CourseLecturer> courseLecturers = new ArrayList<>();
    
    // Add relationship to schedules
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Schedule> schedules = new ArrayList<>();
    
    public enum CourseType {
        lecture, seminar
    }
    
    // Helper methods
    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
        enrollment.setCourse(this);
    }
    
    public void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
        enrollment.setCourse(null);
    }
    
    public void addCourseLecturer(CourseLecturer courseLecturer) {
        courseLecturers.add(courseLecturer);
        courseLecturer.setCourse(this);
    }
    
    public void removeCourseLecturer(CourseLecturer courseLecturer) {
        courseLecturers.remove(courseLecturer);
        courseLecturer.setCourse(null);
    }
    
    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
        schedule.setCourse(this);
    }
    
    public void removeSchedule(Schedule schedule) {
        schedules.remove(schedule);
        schedule.setCourse(null);
    }
}