package com.example.demo.repository;

import com.example.demo.model.ElectiveSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ElectiveSlotRepository extends JpaRepository<ElectiveSlot, String> {
    List<ElectiveSlot> findByStudentId(String studentId);
    List<ElectiveSlot> findByStudentIdAndType(String studentId, ElectiveSlot.ElectiveType type);
    List<ElectiveSlot> findBySelectedCourseId(String courseId);
}