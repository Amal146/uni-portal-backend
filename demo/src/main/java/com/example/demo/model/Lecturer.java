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
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    private String email;
    private String department;
    private String password;
    
    // Relationship: Lecturer coordinates many modules (as module coordinator)
    @OneToMany(mappedBy = "moduleCoordinator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Module> coordinatedModules = new ArrayList<>();
    
    // Relationship: Lecturer teaches many courses (through CourseLecturer)
    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CourseLecturer> courseLecturers = new ArrayList<>();
    
    // Helper methods for coordinated modules
    public void addCoordinatedModule(Module module) {
        coordinatedModules.add(module);
        module.setModuleCoordinator(this);
    }
    
    public void removeCoordinatedModule(Module module) {
        coordinatedModules.remove(module);
        module.setModuleCoordinator(null);
    }
    
    // Helper methods for course lecturers
    public void addCourseLecturer(CourseLecturer courseLecturer) {
        courseLecturers.add(courseLecturer);
        courseLecturer.setLecturer(this);
    }
    
    public void removeCourseLecturer(CourseLecturer courseLecturer) {
        courseLecturers.remove(courseLecturer);
        courseLecturer.setLecturer(null);
    }
    
    // Business methods
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public boolean isModuleCoordinator() {
        return coordinatedModules != null && !coordinatedModules.isEmpty();
    }
    
    public long getTotalModulesCoordinated() {
        return coordinatedModules != null ? coordinatedModules.size() : 0;
    }
    
    public long getTotalCoursesTaught() {
        return courseLecturers != null ? courseLecturers.size() : 0;
    }
}
