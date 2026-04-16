package com.example.demo.service;

import com.example.demo.dto.ExamRegistrationDTO;
import com.example.demo.model.Exam;
import com.example.demo.model.ExamRegistration;
import com.example.demo.model.Student;
import com.example.demo.repository.ExamRegistrationRepository;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

// Updated ExamRegistrationService that returns DTOs
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExamRegistrationService {
    private final ExamRegistrationRepository examRegistrationRepository;
    private final StudentRepository studentRepository;
    private final ExamRepository examRepository;

    public List<ExamRegistrationDTO> getAllExamRegistrations() {
        return ExamRegistrationDTO.fromEntities(examRegistrationRepository.findAll());
    }

    public ExamRegistrationDTO getExamRegistrationById(String id) {
        ExamRegistration registration = examRegistrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExamRegistration not found with id: " + id));
        return ExamRegistrationDTO.fromEntity(registration);
    }

    @Transactional
    public ExamRegistrationDTO createExamRegistration(ExamRegistrationDTO registrationDTO) {
        ExamRegistration registration = convertToEntity(registrationDTO);
        if (registration.getId() == null) {
            registration.setId(java.util.UUID.randomUUID().toString());
        }
        if (registration.getRegisteredAt() == null) {
            registration.setRegisteredAt(LocalDateTime.now());
        }
        if (registration.getAttempt() == null) {
            registration.setAttempt(1);
        }
        ExamRegistration saved = examRegistrationRepository.save(registration);
        return ExamRegistrationDTO.fromEntity(saved);
    }

    @Transactional
    public ExamRegistrationDTO updateExamRegistration(String id, ExamRegistrationDTO registrationDetailsDTO) {
        ExamRegistration registration = getExamRegistrationEntityById(id);
        updateExamRegistrationEntity(registration, registrationDetailsDTO);
        ExamRegistration updated = examRegistrationRepository.save(registration);
        return ExamRegistrationDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteExamRegistration(String id) {
        examRegistrationRepository.deleteById(id);
    }

    public List<ExamRegistrationDTO> getRegistrationsByStudentId(String studentId) {
        return ExamRegistrationDTO.fromEntities(examRegistrationRepository.findByStudentId(studentId));
    }

    public List<ExamRegistrationDTO> getRegistrationsByExamId(String examId) {
        return ExamRegistrationDTO.fromEntities(examRegistrationRepository.findByExamId(examId));
    }

    public ExamRegistrationDTO getRegistrationByStudentIdAndExamId(String studentId, String examId) {
        ExamRegistration registration = examRegistrationRepository.findByStudentIdAndExamId(studentId, examId)
                .orElseThrow(() -> new RuntimeException("Registration not found"));
        return ExamRegistrationDTO.fromEntity(registration);
    }
    
    // Helper methods for internal use
    private ExamRegistration getExamRegistrationEntityById(String id) {
        return examRegistrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExamRegistration not found with id: " + id));
    }
    
    private ExamRegistration convertToEntity(ExamRegistrationDTO dto) {
        ExamRegistration registration = new ExamRegistration();
        registration.setId(dto.getId());
        registration.setRegisteredAt(dto.getRegisteredAt());
        registration.setGrade(dto.getGrade());
        registration.setAttempt(dto.getAttempt());
        
        // Set Student if studentId is provided
        if (dto.getStudentId() != null) {
            Student student = studentRepository.findById(dto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found with id: " + dto.getStudentId()));
            registration.setStudent(student);
        }
        
        // Set Exam if examId is provided
        if (dto.getExamId() != null) {
            Exam exam = examRepository.findById(dto.getExamId())
                    .orElseThrow(() -> new RuntimeException("Exam not found with id: " + dto.getExamId()));
            registration.setExam(exam);
        }
        
        // Set Status if status is provided
        if (dto.getStatus() != null) {
            registration.setStatus(ExamRegistration.RegistrationStatus.valueOf(dto.getStatus()));
        }
        
        return registration;
    }
    
    private void updateExamRegistrationEntity(ExamRegistration registration, ExamRegistrationDTO dto) {
        registration.setRegisteredAt(dto.getRegisteredAt());
        registration.setGrade(dto.getGrade());
        registration.setAttempt(dto.getAttempt());
        
        // Update Student if studentId is provided
        if (dto.getStudentId() != null) {
            Student student = studentRepository.findById(dto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found with id: " + dto.getStudentId()));
            registration.setStudent(student);
        }
        
        // Update Exam if examId is provided
        if (dto.getExamId() != null) {
            Exam exam = examRepository.findById(dto.getExamId())
                    .orElseThrow(() -> new RuntimeException("Exam not found with id: " + dto.getExamId()));
            registration.setExam(exam);
        }
        
        // Update Status if status is provided
        if (dto.getStatus() != null) {
            registration.setStatus(ExamRegistration.RegistrationStatus.valueOf(dto.getStatus()));
        }
    }
}
