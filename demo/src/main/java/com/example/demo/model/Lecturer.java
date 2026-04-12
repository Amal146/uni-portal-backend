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
@Table(name = "lecturer")
public class Lecturer {
    @Id
    private String id;
    
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    
    @Enumerated(EnumType.STRING)
    private LecturerRole role;
    
    @OneToMany
    @JoinColumn(name = "module_coordinator_id")
    private List<Module> coordinatedModules;
    
    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CourseLecturer> courseLecturers = new ArrayList<>();
    
    public enum LecturerRole {
        professor, associate_professor, lecturer, external
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
}