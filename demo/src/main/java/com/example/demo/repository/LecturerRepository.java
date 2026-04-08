package com.example.demo.repository;

import com.example.demo.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, String> {
    
    // Find lecturers by department
    List<Lecturer> findByDepartment(String department);
    
    // Find lecturer by email (exact match)
    Optional<Lecturer> findByEmail(String email);
    
    // Search lecturers by first name (case-insensitive, partial match)
    List<Lecturer> findByFirstNameContainingIgnoreCase(String firstName);
    
    // Search lecturers by last name (case-insensitive, partial match)
    List<Lecturer> findByLastNameContainingIgnoreCase(String lastName);
    
    // Search lecturers by both first name and last name (case-insensitive, partial match)
    List<Lecturer> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
        String firstName, String lastName);
    
    // Count lecturers by department
    long countByDepartment(String department);
}