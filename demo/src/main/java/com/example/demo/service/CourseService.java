package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.model.Course;
import com.example.demo.model.Lecturer;
import com.example.demo.model.Programme;
import com.example.demo.model.Module;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.LecturerRepository;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.repository.ProgrammeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CourseService {
    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;
    private final ProgrammeRepository programmeRepository;
    private final LecturerRepository lecturerRepository;

    public List<CourseDTO> getAllCourses() {
        return CourseDTO.fromEntities(courseRepository.findAll());
    }

    public CourseDTO getCourseById(String id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        return CourseDTO.fromEntity(course);
    }

    @Transactional
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = convertToEntity(courseDTO);
        if (course.getId() == null) {
            course.setId(java.util.UUID.randomUUID().toString());
        }
        Course savedCourse = courseRepository.save(course);
        return CourseDTO.fromEntity(savedCourse);
    }

    @Transactional
    public CourseDTO updateCourse(String id, CourseDTO courseDTO) {
        Course course = getCourseEntityById(id);
        updateCourseEntity(course, courseDTO);
        Course updatedCourse = courseRepository.save(course);
        return CourseDTO.fromEntity(updatedCourse);
    }

    @Transactional
    public void deleteCourse(String id) {
        Course course = getCourseEntityById(id);
        courseRepository.delete(course);
    }

    public List<CourseDTO> getCoursesByModuleId(String moduleId) {
        return CourseDTO.fromEntities(courseRepository.findByModuleId(moduleId));
    }

    public List<CourseDTO> getCoursesByProgrammeId(String programmeId) {
        return CourseDTO.fromEntities(courseRepository.findByProgrammeId(programmeId));
    }

    public List<CourseDTO> getCoursesByType(Course.CourseType type) {
        return CourseDTO.fromEntities(courseRepository.findByType(type));
    }

    public List<CourseDTO> getCoursesByLanguage(String language) {
        return CourseDTO.fromEntities(courseRepository.findByLanguage(language));
    }

    public CourseDTO getCourseByCourseNumber(String courseNumber) {
        Course course = courseRepository.findByCourseNumber(courseNumber)
                .orElseThrow(() -> new RuntimeException("Course not found with number: " + courseNumber));
        return CourseDTO.fromEntity(course);
    }

    public List<CourseDTO> searchCourses(String keyword) {
        return CourseDTO.fromEntities(courseRepository.searchCourses(keyword));
    }
    
    // Helper methods for internal use
    private Course getCourseEntityById(String id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }
    
    private Course convertToEntity(CourseDTO dto) {
        Course course = new Course();
        course.setId(dto.getId());
        course.setCourseNumber(dto.getCourseNumber());
        course.setName(dto.getName());
        course.setShortName(dto.getShortName());
        
        if (dto.getType() != null) {
            course.setType(Course.CourseType.valueOf(dto.getType()));
        }
        
        if (dto.getSeason() != null) {
            course.setSeason(Course.Season.valueOf(dto.getSeason()));
        }
        
        course.setLanguage(dto.getLanguage());
        course.setDescription(dto.getDescription());
        course.setTaughtUnits(dto.getTaughtUnits());
        course.setPrivateStudyTime(dto.getPrivateStudyTime());
        course.setMoodleUrl(dto.getMoodleUrl());
        
        // Set Module if moduleId is provided
        if (dto.getModuleId() != null) {
            Module module = moduleRepository.findById(dto.getModuleId())
                    .orElseThrow(() -> new RuntimeException("Module not found with id: " + dto.getModuleId()));
            course.setModule(module);
        }
        
        // Set Programme if programmeId is provided
        if (dto.getProgrammeId() != null) {
            Programme programme = programmeRepository.findById(dto.getProgrammeId())
                    .orElseThrow(() -> new RuntimeException("Programme not found with id: " + dto.getProgrammeId()));
            course.setProgramme(programme);
        }
        
        // Set Coordinator if coordinatorId is provided
        if (dto.getCoordinatorId() != null) {
            Lecturer coordinator = lecturerRepository.findById(dto.getCoordinatorId())
                    .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + dto.getCoordinatorId()));
            course.setCoordinator(coordinator);
        }
        
        return course;
    }
    
    private void updateCourseEntity(Course course, CourseDTO dto) {
        course.setCourseNumber(dto.getCourseNumber());
        course.setName(dto.getName());
        course.setShortName(dto.getShortName());
        
        if (dto.getType() != null) {
            course.setType(Course.CourseType.valueOf(dto.getType()));
        }
        
        if (dto.getSeason() != null) {
            course.setSeason(Course.Season.valueOf(dto.getSeason()));
        }
        
        course.setLanguage(dto.getLanguage());
        course.setDescription(dto.getDescription());
        course.setTaughtUnits(dto.getTaughtUnits());
        course.setPrivateStudyTime(dto.getPrivateStudyTime());
        course.setMoodleUrl(dto.getMoodleUrl());
        
        // Update Module if moduleId is provided
        if (dto.getModuleId() != null) {
            Module module = moduleRepository.findById(dto.getModuleId())
                    .orElseThrow(() -> new RuntimeException("Module not found with id: " + dto.getModuleId()));
            course.setModule(module);
        }
        
        // Update Programme if programmeId is provided
        if (dto.getProgrammeId() != null) {
            Programme programme = programmeRepository.findById(dto.getProgrammeId())
                    .orElseThrow(() -> new RuntimeException("Programme not found with id: " + dto.getProgrammeId()));
            course.setProgramme(programme);
        }
        
        // Update Coordinator if coordinatorId is provided
        if (dto.getCoordinatorId() != null) {
            Lecturer coordinator = lecturerRepository.findById(dto.getCoordinatorId())
                    .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + dto.getCoordinatorId()));
            course.setCoordinator(coordinator);
        }
    }
}