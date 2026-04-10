package com.example.demo.util;

import com.example.demo.model.Lecturer;
import com.example.demo.model.Student;
import com.example.demo.repository.LecturerRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.UUID;

@Component
public class PasswordInitializer {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private LecturerRepository lecturerRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostConstruct
    public void initializePasswords() {
        // Initialize student passwords
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            if (student.getPassword() == null || student.getPassword().isEmpty()) {
                String randomPassword = UUID.randomUUID().toString().substring(0, 12);
                student.setPassword(passwordEncoder.encode(randomPassword));
                System.out.println("Student: " + student.getEmail() + " | Password: " + randomPassword);
                studentRepository.save(student);
            }
        }
        
        // Initialize lecturer passwords
        List<Lecturer> lecturers = lecturerRepository.findAll();
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getPassword() == null || lecturer.getPassword().isEmpty()) {
                String randomPassword = UUID.randomUUID().toString().substring(0, 12);
                lecturer.setPassword(passwordEncoder.encode(randomPassword));
                System.out.println("Lecturer: " + lecturer.getEmail() + " | Password: " + randomPassword);
                lecturerRepository.save(lecturer);
            }
        }
    }
}
