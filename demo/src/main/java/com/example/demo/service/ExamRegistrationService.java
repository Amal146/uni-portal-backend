package com.example.demo.service;

import com.example.demo.dto.ExamRegistrationDTO;
import com.example.demo.model.ExamRegistration;
import com.example.demo.repository.ExamRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamRegistrationService {
    
    @Autowired
    private ExamRegistrationRepository examRegistrationRepository;
    
    public List<ExamRegistrationDTO> getAllExamRegistrations() {
        return examRegistrationRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public Optional<ExamRegistrationDTO> getExamRegistrationById(String id) {
        return examRegistrationRepository.findById(id).map(this::convertToDTO);
    }
    
    public ExamRegistrationDTO createExamRegistration(ExamRegistrationDTO dto) {
        ExamRegistration entity = convertToEntity(dto);
        ExamRegistration saved = examRegistrationRepository.save(entity);
        return convertToDTO(saved);
    }
    
    public void deleteExamRegistration(String id) {
        examRegistrationRepository.deleteById(id);
    }
    
    public List<ExamRegistrationDTO> getByStudentId(String studentId) {
        return examRegistrationRepository.findByStudentId(studentId).stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public List<ExamRegistrationDTO> getByExamId(String examId) {
        return examRegistrationRepository.findByExamId(examId).stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    private ExamRegistrationDTO convertToDTO(ExamRegistration entity) {
        ExamRegistrationDTO dto = new ExamRegistrationDTO();
        dto.setId(entity.getId());
        dto.setStudentId(entity.getStudent().getId());
        dto.setExamId(entity.getExam().getId());
        dto.setStatus(entity.getStatus().name());
        // add more
        return dto;
    }
    
    private ExamRegistration convertToEntity(ExamRegistrationDTO dto) {
        ExamRegistration entity = new ExamRegistration();
        // simplistic
        entity.setId(dto.getId());
        return entity;
    }
}
