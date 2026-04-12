package com.example.demo.service;

import com.example.demo.model.ExamRegistration;
import com.example.demo.repository.ExamRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExamRegistrationService {
    private final ExamRegistrationRepository examRegistrationRepository;

    public List<ExamRegistration> getAllExamRegistrations() {
        return examRegistrationRepository.findAll();
    }

    public ExamRegistration getExamRegistrationById(String id) {
        return examRegistrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExamRegistration not found with id: " + id));
    }

    @Transactional
    public ExamRegistration createExamRegistration(ExamRegistration registration) {
        if (registration.getId() == null) {
            registration.setId(UUID.randomUUID().toString());
        }
        if (registration.getRegisteredAt() == null) {
            registration.setRegisteredAt(LocalDateTime.now());
        }
        if (registration.getAttempt() == null) {
            registration.setAttempt(1);
        }
        return examRegistrationRepository.save(registration);
    }

    @Transactional
    public ExamRegistration updateExamRegistration(String id, ExamRegistration registrationDetails) {
        ExamRegistration registration = getExamRegistrationById(id);
        registration.setStudent(registrationDetails.getStudent());
        registration.setExam(registrationDetails.getExam());
        registration.setStatus(registrationDetails.getStatus());
        registration.setGrade(registrationDetails.getGrade());
        registration.setAttempt(registrationDetails.getAttempt());
        return examRegistrationRepository.save(registration);
    }

    @Transactional
    public void deleteExamRegistration(String id) {
        examRegistrationRepository.deleteById(id);
    }

    public List<ExamRegistration> getRegistrationsByStudentId(String studentId) {
        return examRegistrationRepository.findByStudentId(studentId);
    }

    public List<ExamRegistration> getRegistrationsByExamId(String examId) {
        return examRegistrationRepository.findByExamId(examId);
    }

    public ExamRegistration getRegistrationByStudentIdAndExamId(String studentId, String examId) {
        return examRegistrationRepository.findByStudentIdAndExamId(studentId, examId)
                .orElseThrow(() -> new RuntimeException("Registration not found"));
    }
}
