package com.example.demo.service;

import com.example.demo.dto.ExamDTO;
import com.example.demo.model.Exam;
import com.example.demo.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamService {
    
    @Autowired
    private ExamRepository examRepository;
    
    public List<ExamDTO> getAllExams() {
        return examRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public Optional<ExamDTO> getExamById(String id) {
        return examRepository.findById(id).map(this::convertToDTO);
    }
    
    public ExamDTO createExam(ExamDTO examDTO) {
        Exam exam = convertToEntity(examDTO);
        Exam saved = examRepository.save(exam);
        return convertToDTO(saved);
    }
    
    public ExamDTO updateExam(String id, ExamDTO examDTO) {
        Exam exam = examRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam not found"));
        // Update fields
        exam.setCourse(examDTO.getCourseId() != null ? new Course() /* simplistic */ : exam.getCourse());
        // ... other fields
        Exam saved = examRepository.save(exam);
        return convertToDTO(saved);
    }
    
    public void deleteExam(String id) {
        examRepository.deleteById(id);
    }
    
    public List<ExamDTO> getExamsByCourse(String courseId) {
        return examRepository.findByCourseId(courseId).stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public List<ExamDTO> getExamsBySemester(String semesterId) {
        return examRepository.findBySemesterId(semesterId).stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    private ExamDTO convertToDTO(Exam exam) {
        ExamDTO dto = new ExamDTO();
        dto.setId(exam.getId());
        dto.setCourseId(exam.getCourse().getId());
        dto.setModuleId(exam.getModule().getId());
        dto.setSemesterId(exam.getSemester().getId());
        dto.setExamType(exam.getType().name());
        dto.setDate(exam.getDate());
        dto.setTime(exam.getTime());
        dto.setDuration(exam.getDuration());
        dto.setRoom(exam.getRoom());
        return dto;
    }
    
    private Exam convertToEntity(ExamDTO dto) {
        Exam exam = new Exam();
        exam.setId(dto.getId());
        // Set other fields, simplistic - in real use mapper
        exam.setDate(dto.getDate());
        // etc.
        return exam;
    }
}
