package com.example.demo.service;

import com.example.demo.config.JwtUtil;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.model.Lecturer;
import com.example.demo.model.Student;
import com.example.demo.repository.LecturerRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private LecturerRepository lecturerRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    public LoginResponse login(LoginRequest request) {
        if ("STUDENT".equalsIgnoreCase(request.getUserType())) {
            Student student = studentRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            
            if (!passwordEncoder.matches(request.getPassword(), student.getPassword())) {
                throw new RuntimeException("Invalid password");
            }
            
            String token = jwtUtil.generateToken(student.getId(), student.getEmail(), "STUDENT");
            return new LoginResponse(token, "STUDENT", student.getId(), student.getEmail());
            
        } else if ("LECTURER".equalsIgnoreCase(request.getUserType())) {
            Lecturer lecturer = lecturerRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("Lecturer not found"));
            
            if (!passwordEncoder.matches(request.getPassword(), lecturer.getPassword())) {
                throw new RuntimeException("Invalid password");
            }
            
            String token = jwtUtil.generateToken(lecturer.getId(), lecturer.getEmail(), "LECTURER");
            return new LoginResponse(token, "LECTURER", lecturer.getId(), lecturer.getEmail());
            
        } else {
            throw new RuntimeException("Invalid user type");
        }
    }
}