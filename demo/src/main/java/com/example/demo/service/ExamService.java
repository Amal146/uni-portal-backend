package com.example.demo.service;

import com.example.demo.dto.ExamDTO;
import com.example.demo.model.Course;
import com.example.demo.model.Exam;
import com.example.demo.model.Semester;
import com.example.demo.model.Module;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.repository.SemesterRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// Updated ExamService that returns DTOs
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExamService {
    private final ExamRepository examRepository;
    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;
    private final SemesterRepository semesterRepository;

    public List<ExamDTO> getAllExams() {
        return ExamDTO.fromEntities(examRepository.findAll());
    }

    public ExamDTO getExamById(String id) {
        Exam exam = examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found with id: " + id));
        return ExamDTO.fromEntity(exam);
    }

    @Transactional
    public ExamDTO createExam(ExamDTO examDTO) {
        Exam exam = convertToEntity(examDTO);
        if (exam.getId() == null) {
            exam.setId(java.util.UUID.randomUUID().toString());
        }
        Exam saved = examRepository.save(exam);
        return ExamDTO.fromEntity(saved);
    }

    @Transactional
    public ExamDTO updateExam(String id, ExamDTO examDetailsDTO) {
        Exam exam = getExamEntityById(id);
        updateExamEntity(exam, examDetailsDTO);
        Exam updated = examRepository.save(exam);
        return ExamDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteExam(String id) {
        examRepository.deleteById(id);
    }

    public List<ExamDTO> getExamsByCourseId(String courseId) {
        return ExamDTO.fromEntities(examRepository.findByCourseId(courseId));
    }

    public List<ExamDTO> getExamsBySemesterId(String semesterId) {
        return ExamDTO.fromEntities(examRepository.findBySemesterId(semesterId));
    }

    public List<ExamDTO> getExamsByModuleId(String moduleId) {
        return ExamDTO.fromEntities(examRepository.findByModuleId(moduleId));
    }
    
    // Helper methods for internal use
    private Exam getExamEntityById(String id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found with id: " + id));
    }
    
    private Exam convertToEntity(ExamDTO dto) {
        Exam exam = new Exam();
        exam.setId(dto.getId());
        exam.setDate(dto.getDate());
        exam.setTime(dto.getTime());
        exam.setDuration(dto.getDuration());
        exam.setRoom(dto.getRoom());
        
        // Set Course if courseId is provided
        if (dto.getCourseId() != null) {
            Course course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourseId()));
            exam.setCourse(course);
        }
        
        // Set Module if moduleId is provided
        if (dto.getModuleId() != null) {
            Module module = moduleRepository.findById(dto.getModuleId())
                    .orElseThrow(() -> new RuntimeException("Module not found with id: " + dto.getModuleId()));
            exam.setModule(module);
        }
        
        // Set Semester if semesterId is provided
        if (dto.getSemesterId() != null) {
            Semester semester = semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id: " + dto.getSemesterId()));
            exam.setSemester(semester);
        }
        
        // Set Type if type is provided
        if (dto.getType() != null) {
            exam.setType(Exam.ExamType.valueOf(dto.getType()));
        }
        
        return exam;
    }
    
    private void updateExamEntity(Exam exam, ExamDTO dto) {
        exam.setDate(dto.getDate());
        exam.setTime(dto.getTime());
        exam.setDuration(dto.getDuration());
        exam.setRoom(dto.getRoom());
        
        // Update Course if courseId is provided
        if (dto.getCourseId() != null) {
            Course course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourseId()));
            exam.setCourse(course);
        }
        
        // Update Module if moduleId is provided
        if (dto.getModuleId() != null) {
            Module module = moduleRepository.findById(dto.getModuleId())
                    .orElseThrow(() -> new RuntimeException("Module not found with id: " + dto.getModuleId()));
            exam.setModule(module);
        }
        
        // Update Semester if semesterId is provided
        if (dto.getSemesterId() != null) {
            Semester semester = semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id: " + dto.getSemesterId()));
            exam.setSemester(semester);
        }
        
        // Update Type if type is provided
        if (dto.getType() != null) {
            exam.setType(Exam.ExamType.valueOf(dto.getType()));
        }
    }
}
