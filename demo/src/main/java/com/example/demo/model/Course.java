package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
    
    public enum CourseType {
        lecture, seminar
    }
}