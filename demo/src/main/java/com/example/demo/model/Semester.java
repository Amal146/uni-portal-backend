package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "semester")
public class Semester {
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    
    private Integer index;
    
    @Enumerated(EnumType.STRING)
    private Season season;
    
    private String label;
    private String shortLabel;
    private Integer calYear;
    
    @ManyToOne
    @JoinColumn(name = "semester_meta_id")
    private SemesterMeta semesterMeta;
    
    public enum Season {
        Winter, Summer
    }
}