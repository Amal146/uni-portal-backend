package com.example.demo.service;

import com.example.demo.model.Exam;
import com.example.demo.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExamService {
    private final ExamRepository examRepository;

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam getExamById(String id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found with id: " + id));
    }

    @Transactional
    public Exam createExam(Exam exam) {
        if (exam.getId() == null) {
            exam.setId(UUID.randomUUID().toString());
        }
        return examRepository.save(exam);
    }

    @Transactional
    public Exam updateExam(String id, Exam examDetails) {
        Exam exam = getExamById(id);
        exam.setCourse(examDetails.getCourse());
        exam.setModule(examDetails.getModule());
        exam.setSemester(examDetails.getSemester());
        exam.setType(examDetails.getType());
        exam.setDate(examDetails.getDate());
        exam.setTime(examDetails.getTime());
        exam.setDuration(examDetails.getDuration());
        exam.setRoom(examDetails.getRoom());
        return examRepository.save(exam);
    }

    @Transactional
    public void deleteExam(String id) {
        examRepository.deleteById(id);
    }

    public List<Exam> getExamsByCourseId(String courseId) {
        return examRepository.findByCourseId(courseId);
    }

    public List<Exam> getExamsBySemesterId(String semesterId) {
        return examRepository.findBySemesterId(semesterId);
    }

    public List<Exam> getExamsByModuleId(String moduleId) {
        return examRepository.findByModuleId(moduleId);
    }
}