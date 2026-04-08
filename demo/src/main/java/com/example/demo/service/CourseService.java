package com.example.demo.service;


import com.example.demo.model.Course;
import com.example.demo.model.Course.CourseType;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private ModuleRepository moduleRepository;
    
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }
    
    public List<Course> getCoursesByModule(String moduleId) {
        return courseRepository.findByModuleId(moduleId);
    }
    
    public List<Course> getCoursesByType(CourseType type) {
        return courseRepository.findByType(type);
    }
    
    public List<Course> getCoursesByLanguage(String language) {
        return courseRepository.findByLanguage(language);
    }
    
    @Transactional
    public Course createCourse(Course course) {
        // Validate module exists
        if (course.getModule() != null && course.getModule().getId() != null) {
            moduleRepository.findById(course.getModule().getId())
                .orElseThrow(() -> new RuntimeException("Module not found"));
        }
        
        // Check for duplicate course number
        if (course.getCourseNumber() != null) {
            Optional<Course> existingCourse = courseRepository.findByCourseNumber(course.getCourseNumber());
            if (existingCourse.isPresent()) {
                throw new RuntimeException("Course number already exists");
            }
        }
        
        return courseRepository.save(course);
    }
    
    @Transactional
    public Course updateCourse(String id, Course courseDetails) {
        Course course = courseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        
        if (courseDetails.getCourseNumber() != null) {
            // Check for duplicate course number (excluding current course)
            Optional<Course> existingCourse = courseRepository.findByCourseNumber(courseDetails.getCourseNumber());
            if (existingCourse.isPresent() && !existingCourse.get().getId().equals(id)) {
                throw new RuntimeException("Course number already exists");
            }
            course.setCourseNumber(courseDetails.getCourseNumber());
        }
        
        if (courseDetails.getName() != null) {
            course.setName(courseDetails.getName());
        }
        
        if (courseDetails.getShortName() != null) {
            course.setShortName(courseDetails.getShortName());
        }
        
        if (courseDetails.getType() != null) {
            course.setType(courseDetails.getType());
        }
        
        if (courseDetails.getThesisPrereq() != null) {
            course.setThesisPrereq(courseDetails.getThesisPrereq());
        }
        
        if (courseDetails.getLanguage() != null) {
            course.setLanguage(courseDetails.getLanguage());
        }
        
        if (courseDetails.getModule() != null && courseDetails.getModule().getId() != null) {
            moduleRepository.findById(courseDetails.getModule().getId())
                .orElseThrow(() -> new RuntimeException("Module not found"));
            course.setModule(courseDetails.getModule());
        }
        
        if (courseDetails.getMoodleUrl() != null) {
            course.setMoodleUrl(courseDetails.getMoodleUrl());
        }
        
        if (courseDetails.getDescription() != null) {
            course.setDescription(courseDetails.getDescription());
        }
        
        if (courseDetails.getCategory() != null) {
            course.setCategory(courseDetails.getCategory());
        }
        
        if (courseDetails.getSeason() != null) {
            course.setSeason(courseDetails.getSeason());
        }
        
        return courseRepository.save(course);
    }
    
    @Transactional
    public void deleteCourse(String id) {
        Course course = courseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        
        // Check if course has any enrollments
        if (course.getEnrollments() != null && !course.getEnrollments().isEmpty()) {
            throw new RuntimeException("Cannot delete course with existing enrollments");
        }
        
        courseRepository.deleteById(id);
    }
    
    public List<Course> searchCourses(String keyword) {
        return courseRepository.searchCourses(keyword);
    }
}
