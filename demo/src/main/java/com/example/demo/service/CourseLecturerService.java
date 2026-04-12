package com.example.demo.service;

import com.example.demo.model.CourseLecturer;
import com.example.demo.repository.CourseLecturerRepository;
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

    public List<CourseLecturer> getAllCourseLecturers() {
        return courseLecturerRepository.findAll();
    }

    public CourseLecturer getCourseLecturerById(String id) {
        return courseLecturerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CourseLecturer not found with id: " + id));
    }

    @Transactional
    public CourseLecturer createCourseLecturer(CourseLecturer courseLecturer) {
        if (courseLecturer.getId() == null) {
            courseLecturer.setId(UUID.randomUUID().toString());
        }
        return courseLecturerRepository.save(courseLecturer);
    }

    @Transactional
    public CourseLecturer updateCourseLecturer(String id, CourseLecturer lecturerDetails) {
        CourseLecturer lecturer = getCourseLecturerById(id);
        lecturer.setCourse(lecturerDetails.getCourse());
        lecturer.setLecturer(lecturerDetails.getLecturer());
        lecturer.setRole(lecturerDetails.getRole());
        return courseLecturerRepository.save(lecturer);
    }

    @Transactional
    public void deleteCourseLecturer(String id) {
        courseLecturerRepository.deleteById(id);
    }

    public List<CourseLecturer> getByCourseId(String courseId) {
        return courseLecturerRepository.findByCourseId(courseId);
    }

    public List<CourseLecturer> getByLecturerId(String lecturerId) {
        return courseLecturerRepository.findByLecturerId(lecturerId);
    }

    public List<CourseLecturer> getByCourseIdAndRole(String courseId, CourseLecturer.Role role) {
        return courseLecturerRepository.findByCourseIdAndRole(courseId, role);
    }
}