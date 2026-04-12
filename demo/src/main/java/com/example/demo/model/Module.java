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
@Table(name = "module")
public class Module {
    
    @Id
    private String id;
    
    private String name;
    
    @Column(name = "short_name")
    private String shortName;
    
    @ManyToOne
    @JoinColumn(name = "programme_id")
    private Programme programme;
    
    private String type;
    
    @Column(name = "total_ects")
    private Integer totalEcts;
    
    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    private Lecturer coordinator;
    
    // Relationship: Module has many courses
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();
    
    // Relationship: Module has many exams
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Exam> exams = new ArrayList<>();
    
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