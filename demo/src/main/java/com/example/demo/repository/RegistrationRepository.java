package com.example.demo.repository;

import com.example.demo.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, String> {
    List<Registration> findByCourseId(String courseId);
    List<Registration> findByRegistrationPeriodId(String registrationPeriodId);
    Optional<Registration> findByStudentIdAndCourseId(String studentId, String courseId);
}