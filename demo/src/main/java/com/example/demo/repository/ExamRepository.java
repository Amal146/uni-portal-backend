package com.example.demo.repository;

import com.example.demo.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, String> {
    List<Exam> findByCourseId(String courseId);
    List<Exam> findBySemesterId(String semesterId);
    List<Exam> findByModuleId(String moduleId);
}
