package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule {
    
    @Id
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    
    @Column(nullable = false)
    private LocalDate date;
    
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;
    
    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;
    
    private String room;
    
    // Helper methods
    public boolean isOverlapping(Schedule other) {
        if (!this.date.equals(other.date)) {
            return false;
        }
        
        return (this.startTime.isBefore(other.endTime) && 
                this.endTime.isAfter(other.startTime));
    }
    
    public long getDurationInMinutes() {
        return java.time.Duration.between(startTime, endTime).toMinutes();
    }
    
    public String getTimeSlot() {
        return startTime.toString() + " - " + endTime.toString();
    }
}