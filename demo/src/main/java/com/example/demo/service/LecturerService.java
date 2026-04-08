package com.example.demo.service;


import com.example.demo.model.Lecturer;
import com.example.demo.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class LecturerService {
    
    @Autowired
    private LecturerRepository lecturerRepository;
    
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }
    
    public Optional<Lecturer> getLecturerById(String id) {
        return lecturerRepository.findById(id);
    }
    
    public List<Lecturer> getLecturersByDepartment(String department) {
        return lecturerRepository.findByDepartment(department);
    }
    
    public Optional<Lecturer> getLecturerByEmail(String email) {
        return lecturerRepository.findByEmail(email);
    }
    
    public List<Lecturer> searchLecturers(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return lecturerRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
                firstName, lastName);
        } else if (firstName != null) {
            return lecturerRepository.findByFirstNameContainingIgnoreCase(firstName);
        } else if (lastName != null) {
            return lecturerRepository.findByLastNameContainingIgnoreCase(lastName);
        }
        return lecturerRepository.findAll();
    }
    
    @Transactional
    public Lecturer createLecturer(Lecturer lecturer) {
        // Validate email
        if (lecturer.getEmail() != null && !EMAIL_PATTERN.matcher(lecturer.getEmail()).matches()) {
            throw new RuntimeException("Invalid email format");
        }
        
        // Check for duplicate email
        if (lecturer.getEmail() != null) {
            Optional<Lecturer> existingLecturer = lecturerRepository.findByEmail(lecturer.getEmail());
            if (existingLecturer.isPresent()) {
                throw new RuntimeException("Email already exists");
            }
        }
        
        return lecturerRepository.save(lecturer);
    }
    
    @Transactional
    public Lecturer updateLecturer(String id, Lecturer lecturerDetails) {
        Lecturer lecturer = lecturerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + id));
        
        if (lecturerDetails.getFirstName() != null) {
            lecturer.setFirstName(lecturerDetails.getFirstName());
        }
        
        if (lecturerDetails.getLastName() != null) {
            lecturer.setLastName(lecturerDetails.getLastName());
        }
        
        if (lecturerDetails.getEmail() != null) {
            // Validate email format
            if (!EMAIL_PATTERN.matcher(lecturerDetails.getEmail()).matches()) {
                throw new RuntimeException("Invalid email format");
            }
            
            // Check for duplicate email (excluding current lecturer)
            Optional<Lecturer> existingLecturer = lecturerRepository.findByEmail(lecturerDetails.getEmail());
            if (existingLecturer.isPresent() && !existingLecturer.get().getId().equals(id)) {
                throw new RuntimeException("Email already exists");
            }
            lecturer.setEmail(lecturerDetails.getEmail());
        }
        
        if (lecturerDetails.getDepartment() != null) {
            lecturer.setDepartment(lecturerDetails.getDepartment());
        }
        
        return lecturerRepository.save(lecturer);
    }
    
    @Transactional
    public void deleteLecturer(String id) {
        Lecturer lecturer = lecturerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + id));
        
        // Check if lecturer is module coordinator for any module
        if (lecturer.getCoordinatedModules() != null && !lecturer.getCoordinatedModules().isEmpty()) {
            throw new RuntimeException("Cannot delete lecturer who coordinates modules");
        }
        
        lecturerRepository.deleteById(id);
    }
    
    public long getLecturerCountByDepartment(String department) {
        return lecturerRepository.countByDepartment(department);
    }
}
