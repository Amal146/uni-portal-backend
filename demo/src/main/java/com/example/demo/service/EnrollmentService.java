package com.example.demo.service;


import com.example.demo.model.Enrollment;
import com.example.demo.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {
    
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
    
    public Optional<Enrollment> getEnrollmentById(String id) {
        return enrollmentRepository.findById(id);
    }
    
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }
    
    public Enrollment updateEnrollment(String id, Enrollment enrollmentDetails) {
        Enrollment enrollment = enrollmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        
        enrollment.setStatus(enrollmentDetails.getStatus());
        enrollment.setPlannedSemester(enrollmentDetails.getPlannedSemester());
        
        return enrollmentRepository.save(enrollment);
    }
    
    public void deleteEnrollment(String id) {
        enrollmentRepository.deleteById(id);
    }
    
    public List<Enrollment> getEnrollmentsByStudent(String studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }
    
    public List<Enrollment> getEnrollmentsByCourse(String courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }
    
    public List<Enrollment> getStudentActiveEnrollments(String studentId) {
        return enrollmentRepository.findByStudentIdAndStatus(studentId, Enrollment.EnrollmentStatus.registered);
    }
}