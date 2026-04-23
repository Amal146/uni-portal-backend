package com.example.demo.service;

import com.example.demo.dto.CoursePrerequisiteDTO;
import com.example.demo.model.CoursePrerequisite;
import com.example.demo.repository.CoursePrerequisiteRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CoursePrerequisiteService {
    private final CoursePrerequisiteRepository prerequisiteRepository;
    
    // GET all prerequisites
    public List<CoursePrerequisiteDTO> getAllPrerequisites() {
        return CoursePrerequisiteDTO.fromEntities(prerequisiteRepository.findAll());
    }
    
    // GET prerequisite by ID
    public CoursePrerequisiteDTO getPrerequisiteById(String id) {
        CoursePrerequisite prerequisite = prerequisiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course prerequisite not found with id: " + id));
        return CoursePrerequisiteDTO.fromEntity(prerequisite);
    }
    
    // GET prerequisites by course ID
    public List<CoursePrerequisiteDTO> getPrerequisitesByCourseId(String courseId) {
        return CoursePrerequisiteDTO.fromEntities(
            prerequisiteRepository.findPrerequisitesWithDetailsByCourseId(courseId)
        );
    }
    
    // GET prerequisites by course ID and programme ID
    public List<CoursePrerequisiteDTO> getPrerequisitesByCourseIdAndProgrammeId(String courseId, String programmeId) {
        return CoursePrerequisiteDTO.fromEntities(
            prerequisiteRepository.findByCourseIdAndProgrammeId(courseId, programmeId)
        );
    }
    
    // GET courses that require a specific course as prerequisite
    public List<CoursePrerequisiteDTO> getCoursesRequiringPrerequisite(String requiredCourseId) {
        return CoursePrerequisiteDTO.fromEntities(
            prerequisiteRepository.findByRequiredCourseId(requiredCourseId)
        );
    }
    
    // GET prerequisites by programme ID
    public List<CoursePrerequisiteDTO> getPrerequisitesByProgrammeId(String programmeId) {
        return CoursePrerequisiteDTO.fromEntities(
            prerequisiteRepository.findByProgrammeId(programmeId)
        );
    }
    
    // GET check if prerequisite exists
    public boolean checkPrerequisiteExists(String courseId, String requiredCourseId, String programmeId) {
        return prerequisiteRepository.existsByCourseIdAndRequiredCourseIdAndProgrammeId(
            courseId, requiredCourseId, programmeId
        );
    }
}