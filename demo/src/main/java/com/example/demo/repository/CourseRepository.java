package com.example.demo.repository;

import com.example.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    
    // Existing methods

    List<Course> findByProgrammeId(String programmeId);
    List<Course> findByModuleId(String moduleId);
    
    List<Course> findByType(Course.CourseType type);
    
    // Missing methods from CourseService
    List<Course> findByLanguage(String language);
    
    Optional<Course> findByCourseNumber(String courseNumber);
    
    @Query("SELECT c FROM Course c WHERE " +
           "LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(c.shortName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(c.courseNumber) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(c.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Course> searchCourses(@Param("keyword") String keyword);
}