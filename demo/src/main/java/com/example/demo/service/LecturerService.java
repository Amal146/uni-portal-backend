package com.example.demo.service;

import com.example.demo.dto.LecturerDTO;
import com.example.demo.model.Lecturer;
import com.example.demo.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Updated LecturerService that returns DTOs
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LecturerService {
    private final LecturerRepository lecturerRepository;

    public List<LecturerDTO> getAllLecturers() {
        return LecturerDTO.fromEntities(lecturerRepository.findAll());
    }

    public LecturerDTO getLecturerById(String id) {
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + id));
        return LecturerDTO.fromEntity(lecturer);
    }

    @Transactional
    public LecturerDTO createLecturer(LecturerDTO lecturerDTO) {
        Lecturer lecturer = convertToEntity(lecturerDTO);
        if (lecturer.getId() == null) {
            lecturer.setId(java.util.UUID.randomUUID().toString());
        }
        Lecturer saved = lecturerRepository.save(lecturer);
        return LecturerDTO.fromEntity(saved);
    }

    @Transactional
    public LecturerDTO updateLecturer(String id, LecturerDTO lecturerDetailsDTO) {
        Lecturer lecturer = getLecturerEntityById(id);
        updateLecturerEntity(lecturer, lecturerDetailsDTO);
        Lecturer updated = lecturerRepository.save(lecturer);
        return LecturerDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteLecturer(String id) {
        lecturerRepository.deleteById(id);
    }

    public List<LecturerDTO> getLecturersByDepartment(String department) {
        return LecturerDTO.fromEntities(lecturerRepository.findByDepartment(department));
    }

    public LecturerDTO getLecturerByEmail(String email) {
        Lecturer lecturer = lecturerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Lecturer not found with email: " + email));
        return LecturerDTO.fromEntity(lecturer);
    }

    public List<LecturerDTO> searchLecturersByFirstName(String firstName) {
        return LecturerDTO.fromEntities(lecturerRepository.findByFirstNameContainingIgnoreCase(firstName));
    }

    public List<LecturerDTO> searchLecturersByLastName(String lastName) {
        return LecturerDTO.fromEntities(lecturerRepository.findByLastNameContainingIgnoreCase(lastName));
    }

    public List<LecturerDTO> searchLecturersByName(String firstName, String lastName) {
        return LecturerDTO.fromEntities(lecturerRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName));
    }

    public long countLecturersByDepartment(String department) {
        return lecturerRepository.countByDepartment(department);
    }
    
    // Helper methods for internal use
    private Lecturer getLecturerEntityById(String id) {
        return lecturerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + id));
    }
    
    private Lecturer convertToEntity(LecturerDTO dto) {
        Lecturer lecturer = new Lecturer();
        lecturer.setId(dto.getId());
        lecturer.setTitle(dto.getTitle());
        lecturer.setFirstName(dto.getFirstName());
        lecturer.setLastName(dto.getLastName());
        lecturer.setEmail(dto.getEmail());
        lecturer.setDepartment(dto.getDepartment());
        
        // Set Role if role is provided
        if (dto.getRole() != null) {
            lecturer.setRole(Lecturer.LecturerRole.valueOf(dto.getRole()));
        }
        
        return lecturer;
    }
    
    private void updateLecturerEntity(Lecturer lecturer, LecturerDTO dto) {
        lecturer.setTitle(dto.getTitle());
        lecturer.setFirstName(dto.getFirstName());
        lecturer.setLastName(dto.getLastName());
        lecturer.setEmail(dto.getEmail());
        lecturer.setDepartment(dto.getDepartment());
        
        // Update Role if role is provided
        if (dto.getRole() != null) {
            lecturer.setRole(Lecturer.LecturerRole.valueOf(dto.getRole()));
        }
    }
}
