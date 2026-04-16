package com.example.demo.service;

import com.example.demo.dto.CourseLecturerDTO;
import com.example.demo.model.Course;
import com.example.demo.model.CourseLecturer;
import com.example.demo.model.Lecturer;
import com.example.demo.repository.CourseLecturerRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.LecturerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CourseLecturerService {
    private final CourseLecturerRepository courseLecturerRepository;
    private final CourseRepository courseRepository;
    private final LecturerRepository lecturerRepository;

    public List<CourseLecturerDTO> getAllCourseLecturers() {
        return CourseLecturerDTO.fromEntities(courseLecturerRepository.findAll());
    }

    public CourseLecturerDTO getCourseLecturerById(String id) {
        CourseLecturer courseLecturer = courseLecturerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CourseLecturer not found with id: " + id));
        return CourseLecturerDTO.fromEntity(courseLecturer);
    }

    @Transactional
    public CourseLecturerDTO createCourseLecturer(CourseLecturerDTO courseLecturerDTO) {
        CourseLecturer courseLecturer = convertToEntity(courseLecturerDTO);
        if (courseLecturer.getId() == null) {
            courseLecturer.setId(UUID.randomUUID().toString());
        }
        CourseLecturer saved = courseLecturerRepository.save(courseLecturer);
        return CourseLecturerDTO.fromEntity(saved);
    }

    @Transactional
    public CourseLecturerDTO updateCourseLecturer(String id, CourseLecturerDTO lecturerDetailsDTO) {
        CourseLecturer lecturer = getCourseLecturerEntityById(id);
        updateCourseLecturerEntity(lecturer, lecturerDetailsDTO);
        CourseLecturer updated = courseLecturerRepository.save(lecturer);
        return CourseLecturerDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteCourseLecturer(String id) {
        courseLecturerRepository.deleteById(id);
    }

    public List<CourseLecturerDTO> getByCourseId(String courseId) {
        return CourseLecturerDTO.fromEntities(courseLecturerRepository.findByCourseId(courseId));
    }

    public List<CourseLecturerDTO> getByLecturerId(String lecturerId) {
        return CourseLecturerDTO.fromEntities(courseLecturerRepository.findByLecturerId(lecturerId));
    }

    public List<CourseLecturerDTO> getByCourseIdAndRole(String courseId, String role) {
        CourseLecturer.Role roleEnum = CourseLecturer.Role.valueOf(role);
        return CourseLecturerDTO.fromEntities(courseLecturerRepository.findByCourseIdAndRole(courseId, roleEnum));
    }
    
    // Helper methods for internal use
    private CourseLecturer getCourseLecturerEntityById(String id) {
        return courseLecturerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CourseLecturer not found with id: " + id));
    }
    
    private CourseLecturer convertToEntity(CourseLecturerDTO dto) {
        CourseLecturer courseLecturer = new CourseLecturer();
        courseLecturer.setId(dto.getId());
        
        // Set Course if courseId is provided
        if (dto.getCourseId() != null) {
            Course course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourseId()));
            courseLecturer.setCourse(course);
        }
        
        // Set Lecturer if lecturerId is provided
        if (dto.getLecturerId() != null) {
            Lecturer lecturer = lecturerRepository.findById(dto.getLecturerId())
                    .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + dto.getLecturerId()));
            courseLecturer.setLecturer(lecturer);
        }
        
        // Set Role if role is provided
        if (dto.getRole() != null) {
            courseLecturer.setRole(CourseLecturer.Role.valueOf(dto.getRole()));
        }
        
        return courseLecturer;
    }
    
    private void updateCourseLecturerEntity(CourseLecturer courseLecturer, CourseLecturerDTO dto) {
        // Update Course if courseId is provided
        if (dto.getCourseId() != null) {
            Course course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourseId()));
            courseLecturer.setCourse(course);
        }
        
        // Update Lecturer if lecturerId is provided
        if (dto.getLecturerId() != null) {
            Lecturer lecturer = lecturerRepository.findById(dto.getLecturerId())
                    .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + dto.getLecturerId()));
            courseLecturer.setLecturer(lecturer);
        }
        
        // Update Role if role is provided
        if (dto.getRole() != null) {
            courseLecturer.setRole(CourseLecturer.Role.valueOf(dto.getRole()));
        }
    }
}