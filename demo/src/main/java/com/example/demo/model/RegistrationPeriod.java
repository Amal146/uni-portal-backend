package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registration_period")
public class RegistrationPeriod {
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RegistrationType type;
    
    @Column(nullable = false)
    private LocalDate openDate;
    
    @Column(nullable = false)
    private LocalDate closeDate;
    
    private LocalDate deregDeadline;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RegistrationStatus status;
    
    @OneToMany(mappedBy = "registrationPeriod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Registration> registrations = new ArrayList<>();
    
    public enum RegistrationType {
        course, exam, deregistration
    }
    
    public enum RegistrationStatus {
        upcoming, open, closed
    }
    
    public void addRegistration(Registration registration) {
        registrations.add(registration);
        registration.setRegistrationPeriod(this);
    }
    
    public void removeRegistration(Registration registration) {
        registrations.remove(registration);
        registration.setRegistrationPeriod(null);
    }
}