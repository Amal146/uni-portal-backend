package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import  lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "module")
public class Module {
    
    @Id
    private String id;
    
    @Column(name = "module_code")
    private String moduleCode;
    
    private String name;
    private Integer ects;
    
    @Enumerated(EnumType.STRING)
    private ModuleType type;
    
    private Integer niveau;
    
    @Column(name = "taught_units_per_semester")
    private Integer taughtUnitsPerSemester;
    
    @Column(name = "private_study_time")
    private Integer privateStudyTime;
    
    @ManyToOne
    @JoinColumn(name = "programme_id")
    private Programme programme;
    
    @ManyToOne
    @JoinColumn(name = "module_coordinator_id")
    private Lecturer moduleCoordinator;
    
    @Column(name = "exam_procedure")
    private String examProcedure;
    
    private String requirements;
    private String content;
    
    @Column(name = "learning_outcomes")
    private String learningOutcomes;
    
    private String literature;
    
    // Relationship: Module has many courses
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();
    
    // Relationship: Module has many exams
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Exam> exams = new ArrayList<>();
    
    public enum ModuleType {
        compulsory, elective
    }
    
    // Helper methods for courses
    public void addCourse(Course course) {
        courses.add(course);
        course.setModule(this);
    }
    
    public void removeCourse(Course course) {
        courses.remove(course);
        course.setModule(null);
    }
    
    // Helper methods for exams
    public void addExam(Exam exam) {
        exams.add(exam);
        exam.setModule(this);
    }
    
    public void removeExam(Exam exam) {
        exams.remove(exam);
        exam.setModule(null);
    }
    
    // Business methods
    public int getTotalEcts() {
        return ects != null ? ects : 0;
    }
    
    public boolean hasCourses() {
        return courses != null && !courses.isEmpty();
    }
    
    public boolean hasExams() {
        return exams != null && !exams.isEmpty();
    }
    
    public long getTotalCourses() {
        return courses != null ? courses.size() : 0;
    }
    
    public long getTotalExams() {
        return exams != null ? exams.size() : 0;
    }
}