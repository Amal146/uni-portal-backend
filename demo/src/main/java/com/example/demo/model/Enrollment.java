package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;
    
    @ManyToOne
    @JoinColumn(name = "planned_semester_id")
    private Semester plannedSemester;
    
    public enum EnrollmentStatus {
        registered, completed, pending
    }
}