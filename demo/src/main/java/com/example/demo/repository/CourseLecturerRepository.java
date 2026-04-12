package com.example.demo.repository;

import com.example.demo.model.CourseLecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseLecturerRepository extends JpaRepository<CourseLecturer, String> {
    List<CourseLecturer> findByCourseId(String courseId);
    List<CourseLecturer> findByLecturerId(String lecturerId);
    List<CourseLecturer> findByCourseIdAndRole(String courseId, CourseLecturer.Role role);
}