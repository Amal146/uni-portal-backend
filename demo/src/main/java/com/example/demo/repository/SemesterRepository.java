package com.example.demo.repository;

import com.example.demo.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, String> {
    List<Semester> findByStudentId(String studentId);
    List<Semester> findBySemesterMetaId(String semesterMetaId);
}