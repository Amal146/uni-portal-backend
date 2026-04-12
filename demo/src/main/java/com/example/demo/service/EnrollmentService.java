package com.example.demo.service;

import com.example.demo.model.Enrollment;
import com.example.demo.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment getEnrollmentById(String id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
    }

    @Transactional
    public Enrollment createEnrollment(Enrollment enrollment) {
        if (enrollment.getId() == null) {
            enrollment.setId(UUID.randomUUID().toString());
        }
        if (enrollment.getEnrolledAt() == null) {
            enrollment.setEnrolledAt(LocalDateTime.now());
        }
        return enrollmentRepository.save(enrollment);
    }

    @Transactional
    public Enrollment updateEnrollment(String id, Enrollment enrollmentDetails) {
        Enrollment enrollment = getEnrollmentById(id);
        enrollment.setStudent(enrollmentDetails.getStudent());
        enrollment.setCourse(enrollmentDetails.getCourse());
        enrollment.setSemester(enrollmentDetails.getSemester());
        enrollment.setPlannedSlot(enrollmentDetails.getPlannedSlot());
        enrollment.setStatus(enrollmentDetails.getStatus());
        enrollment.setGrade(enrollmentDetails.getGrade());
        return enrollmentRepository.save(enrollment);
    }

    @Transactional
    public void deleteEnrollment(String id) {
        enrollmentRepository.deleteById(id);
    }

    public List<Enrollment> getEnrollmentsByStudentId(String studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourseId(String courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public List<Enrollment> getEnrollmentsByStudentIdAndStatus(String studentId, Enrollment.EnrollmentStatus status) {
        return enrollmentRepository.findByStudentIdAndStatus(studentId, status);
    }
}