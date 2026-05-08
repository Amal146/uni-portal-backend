package com.example.demo.service;

import com.example.demo.dto.EnrollmentDTO;
import com.example.demo.model.Course;
import com.example.demo.model.Enrollment;
import com.example.demo.model.Semester;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.SemesterRepository;
import com.example.demo.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final SemesterRepository semesterRepository;

    public List<EnrollmentDTO> getAllEnrollments() {
        return EnrollmentDTO.fromEntities(enrollmentRepository.findAll());
    }

    public EnrollmentDTO getEnrollmentById(String id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
        return EnrollmentDTO.fromEntity(enrollment);
    }

    @Transactional
    public EnrollmentDTO createEnrollment(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = convertToEntity(enrollmentDTO);
        if (enrollment.getId() == null) {
            enrollment.setId(java.util.UUID.randomUUID().toString());
        }
        if (enrollment.getEnrolledAt() == null) {
            enrollment.setEnrolledAt(LocalDateTime.now());
        }
        Enrollment saved = enrollmentRepository.save(enrollment);
        return EnrollmentDTO.fromEntity(saved);
    }

    @Transactional
    public EnrollmentDTO updateEnrollment(String id, EnrollmentDTO enrollmentDetailsDTO) {
        Enrollment enrollment = getEnrollmentEntityById(id);
        updateEnrollmentEntity(enrollment, enrollmentDetailsDTO);
        Enrollment updated = enrollmentRepository.save(enrollment);
        return EnrollmentDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteEnrollment(String id) {
        enrollmentRepository.deleteById(id);
    }

    public List<EnrollmentDTO> getEnrollmentsByStudentId(String studentId) {
        return EnrollmentDTO.fromEntities(enrollmentRepository.findByStudentId(studentId));
    }

    public List<EnrollmentDTO> getEnrollmentsByCourseId(String courseId) {
        return EnrollmentDTO.fromEntities(enrollmentRepository.findByCourseId(courseId));
    }

    public List<EnrollmentDTO> getEnrollmentsByStudentIdAndStatus(String studentId, String status) {
        Enrollment.EnrollmentStatus statusEnum = Enrollment.EnrollmentStatus.valueOf(status);
        return EnrollmentDTO.fromEntities(enrollmentRepository.findByStudentIdAndStatus(studentId, statusEnum));
    }
    
    // Helper methods for internal use
    private Enrollment getEnrollmentEntityById(String id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
    }
    
    private Enrollment convertToEntity(EnrollmentDTO dto) {
        Enrollment enrollment = new Enrollment();
        enrollment.setId(dto.getId());
        enrollment.setPlannedSlot(dto.getPlannedSlot());
        enrollment.setEnrolledAt(dto.getEnrolledAt());
        
        // Set Student if studentId is provided
        if (dto.getStudentId() != null) {
            Student student = studentRepository.findById(dto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found with id: " + dto.getStudentId()));
            enrollment.setStudent(student);
        }
        
        // Set Course if courseId is provided
        if (dto.getCourseId() != null) {
            Course course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourseId()));
            enrollment.setCourse(course);
        }
        
        // Set Semester if semesterId is provided
        if (dto.getSemesterId() != null) {
            Semester semester = semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id: " + dto.getSemesterId()));
            enrollment.setSemester(semester);
        }
        
        // Set Status if status is provided
        if (dto.getStatus() != null) {
            enrollment.setStatus(Enrollment.EnrollmentStatus.valueOf(dto.getStatus()));
        }
        
        return enrollment;
    }
    
    private void updateEnrollmentEntity(Enrollment enrollment, EnrollmentDTO dto) {
        enrollment.setPlannedSlot(dto.getPlannedSlot());
        enrollment.setEnrolledAt(dto.getEnrolledAt());
        
        // Update Student if studentId is provided
        if (dto.getStudentId() != null) {
            Student student = studentRepository.findById(dto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found with id: " + dto.getStudentId()));
            enrollment.setStudent(student);
        }
        
        // Update Course if courseId is provided
        if (dto.getCourseId() != null) {
            Course course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourseId()));
            enrollment.setCourse(course);
        }
        
        // Update Semester if semesterId is provided
        if (dto.getSemesterId() != null) {
            Semester semester = semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id: " + dto.getSemesterId()));
            enrollment.setSemester(semester);
        }
        
        // Update Status if status is provided
        if (dto.getStatus() != null) {
            enrollment.setStatus(Enrollment.EnrollmentStatus.valueOf(dto.getStatus()));
        }
    }

    public Map<String, Long> getRegisteredCountsBySemesterId(String semesterId) {
    List<Object[]> rows = enrollmentRepository.countRegisteredBySemesterId(semesterId);
    Map<String, Long> result = new HashMap<>();
    for (Object[] row : rows) {
        result.put((String) row[0], (Long) row[1]);
    }
    return result;
}
}