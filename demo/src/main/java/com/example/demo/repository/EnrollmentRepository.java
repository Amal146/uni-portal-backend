package com.example.demo.repository;

import com.example.demo.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, String> {
    List<Enrollment> findByStudentId(String studentId);
    List<Enrollment> findByCourseId(String courseId);
    List<Enrollment> findByStudentIdAndStatus(String studentId, Enrollment.EnrollmentStatus status);
    @Query("SELECT e.course.id, COUNT(e) FROM Enrollment e " +
       "WHERE e.semester.id = :semesterId AND e.status = 'registered' " +
       "GROUP BY e.course.id")
    List<Object[]> countRegisteredBySemesterId(@Param("semesterId") String semesterId);
}