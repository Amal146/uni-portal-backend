package com.example.demo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.demo.model.Enrollment.EnrollmentStatus;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDTO {
    private String id;
    private String studentId;
    private String studentName;
    private String courseId;
    private String courseName;
    private EnrollmentStatus status;
    private String plannedSemesterId;
    private String plannedSemesterName;
    private LocalDateTime enrollmentDate;
    private LocalDateTime completionDate;
    private Integer grade;
    private String remarks;
}