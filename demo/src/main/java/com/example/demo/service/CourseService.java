package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(String id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    @Transactional
    public Course createCourse(Course course) {
        if (course.getId() == null) {
            course.setId(java.util.UUID.randomUUID().toString());
        }
        return courseRepository.save(course);
    }

    @Transactional
    public Course updateCourse(String id, Course courseDetails) {
        Course course = getCourseById(id);
        course.setCourseNumber(courseDetails.getCourseNumber());
        course.setName(courseDetails.getName());
        course.setShortName(courseDetails.getShortName());
        course.setType(courseDetails.getType());
        course.setModule(courseDetails.getModule());
        course.setProgramme(courseDetails.getProgramme());
        course.setLanguage(courseDetails.getLanguage());
        course.setSeason(courseDetails.getSeason());
        course.setDescription(courseDetails.getDescription());
        course.setTaughtUnits(courseDetails.getTaughtUnits());
        course.setPrivateStudyTime(courseDetails.getPrivateStudyTime());
        course.setThesisPrereq(courseDetails.getThesisPrereq());
        course.setMoodleUrl(courseDetails.getMoodleUrl());
        course.setCoordinator(courseDetails.getCoordinator());
        course.setCategory(courseDetails.getCategory());
        return courseRepository.save(course);
    }

    @Transactional
    public void deleteCourse(String id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }

    public List<Course> getCoursesByModuleId(String moduleId) {
        return courseRepository.findByModuleId(moduleId);
    }

    public List<Course> getCoursesByType(Course.CourseType type) {
        return courseRepository.findByType(type);
    }

    public List<Course> getCoursesByLanguage(String language) {
        return courseRepository.findByLanguage(language);
    }

    public Course getCourseByCourseNumber(String courseNumber) {
        return courseRepository.findByCourseNumber(courseNumber)
                .orElseThrow(() -> new RuntimeException("Course not found with number: " + courseNumber));
    }

    public List<Course> searchCourses(String keyword) {
        return courseRepository.searchCourses(keyword);
    }
}