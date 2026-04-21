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
@Table(name = "student")
public class Student {
    @Id
    private String id;
    
    @Column(name = "user_id")
    private String userId;  // FK to auth.users
    
    private String matricNumber;
    private String firstName;
    private String lastName;
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "programme_id")
    private Programme programme;
    
    @Column(name = "start_semester")
    private String startSemester;
    
    @Enumerated(EnumType.STRING)
    private Season startSeason;
    
    private Integer startYear;
    private Integer maxYears;
    
    
    
    @Enumerated(EnumType.STRING)
    private StudentStatus status;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    // Relationships
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollments = new ArrayList<>();
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExamRegistration> examRegistrations = new ArrayList<>();
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ElectiveSlot> electiveSlots = new ArrayList<>();
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Registration> registrations = new ArrayList<>();
    
    public enum Season {
        Winter, Summer
    }
    
    public enum StudentStatus {
        active, completed, withdrawn
    }
    
    public enum Role {
        student, lecturer
    }
    
    // Helper methods
    public String getFullName() {
        return firstName + " " + lastName;
    }
}