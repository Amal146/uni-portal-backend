package com.example.demo.repository;

import com.example.demo.model.CoursePrerequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CoursePrerequisiteRepository extends JpaRepository<CoursePrerequisite, String> {
    
    // Find all prerequisites for a specific course
    List<CoursePrerequisite> findByCourseId(String courseId);
    
    // Find all prerequisites for a specific course and programme
    List<CoursePrerequisite> findByCourseIdAndProgrammeId(String courseId, String programmeId);
    
    // Find all courses that require a specific course as prerequisite
    List<CoursePrerequisite> findByRequiredCourseId(String requiredCourseId);
    
    // Find all prerequisites for a specific programme
    List<CoursePrerequisite> findByProgrammeId(String programmeId);
    
    // Check if a prerequisite relationship exists
    boolean existsByCourseIdAndRequiredCourseIdAndProgrammeId(String courseId, String requiredCourseId, String programmeId);
    
    // Delete all prerequisites for a course
    void deleteByCourseId(String courseId);
    
    // Delete all prerequisites for a course and programme
    void deleteByCourseIdAndProgrammeId(String courseId, String programmeId);
    
    // Custom query to get prerequisite courses with details
    @Query("SELECT cp FROM CoursePrerequisite cp " +
           "LEFT JOIN FETCH cp.course " +
           "LEFT JOIN FETCH cp.requiredCourse " +
           "LEFT JOIN FETCH cp.programme " +
           "WHERE cp.course.id = :courseId")
    List<CoursePrerequisite> findPrerequisitesWithDetailsByCourseId(@Param("courseId") String courseId);
}