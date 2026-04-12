package com.example.demo.service;

import com.example.demo.model.Lecturer;
import com.example.demo.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LecturerService {
    private final LecturerRepository lecturerRepository;

    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    public Lecturer getLecturerById(String id) {
        return lecturerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + id));
    }

    @Transactional
    public Lecturer createLecturer(Lecturer lecturer) {
        if (lecturer.getId() == null) {
            lecturer.setId(UUID.randomUUID().toString());
        }
        return lecturerRepository.save(lecturer);
    }

    @Transactional
    public Lecturer updateLecturer(String id, Lecturer lecturerDetails) {
        Lecturer lecturer = getLecturerById(id);
        lecturer.setTitle(lecturerDetails.getTitle());
        lecturer.setFirstName(lecturerDetails.getFirstName());
        lecturer.setLastName(lecturerDetails.getLastName());
        lecturer.setEmail(lecturerDetails.getEmail());
        lecturer.setDepartment(lecturerDetails.getDepartment());
        lecturer.setRole(lecturerDetails.getRole());
        return lecturerRepository.save(lecturer);
    }

    @Transactional
    public void deleteLecturer(String id) {
        lecturerRepository.deleteById(id);
    }

    public List<Lecturer> getLecturersByDepartment(String department) {
        return lecturerRepository.findByDepartment(department);
    }

    public Lecturer getLecturerByEmail(String email) {
        return lecturerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Lecturer not found with email: " + email));
    }

    public List<Lecturer> searchLecturersByFirstName(String firstName) {
        return lecturerRepository.findByFirstNameContainingIgnoreCase(firstName);
    }

    public List<Lecturer> searchLecturersByLastName(String lastName) {
        return lecturerRepository.findByLastNameContainingIgnoreCase(lastName);
    }

    public List<Lecturer> searchLecturersByName(String firstName, String lastName) {
        return lecturerRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName);
    }

    public long countLecturersByDepartment(String department) {
        return lecturerRepository.countByDepartment(department);
    }
}