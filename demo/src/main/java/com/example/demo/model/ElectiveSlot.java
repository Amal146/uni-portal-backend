package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "elective_slot")
public class ElectiveSlot {
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ElectiveType type;
    
    private String label;
    
    private Integer slotNumber;
    
    private Integer plannedSlot;
    
    @ManyToOne
    @JoinColumn(name = "planned_semester_id")
    private SemesterMeta plannedSemester;
    
    @ManyToOne
    @JoinColumn(name = "selected_course_id")
    private Course selectedCourse;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ElectiveStatus status;
    
    public enum ElectiveType {
        core_elective, cross_faculty
    }
    
    public enum ElectiveStatus {
        completed, registered, pending
    }
}