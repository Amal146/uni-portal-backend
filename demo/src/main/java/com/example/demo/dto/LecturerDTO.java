package com.example.demo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Lecturer;

import lombok.AllArgsConstructor;


// LecturerDTO with flat fields
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LecturerDTO {
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String role;
    
    // Static method to convert from Entity to DTO
    public static LecturerDTO fromEntity(Lecturer lecturer) {
        if (lecturer == null) return null;
        
        LecturerDTO dto = new LecturerDTO();
        dto.setId(lecturer.getId());
        dto.setTitle(lecturer.getTitle());
        dto.setFirstName(lecturer.getFirstName());
        dto.setLastName(lecturer.getLastName());
        dto.setEmail(lecturer.getEmail());
        dto.setDepartment(lecturer.getDepartment());
        dto.setRole(lecturer.getRole() != null ? lecturer.getRole().name() : null);
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<LecturerDTO> fromEntities(List<Lecturer> lecturers) {
        if (lecturers == null) return new ArrayList<>();
        List<LecturerDTO> dtos = new ArrayList<>();
        for (Lecturer lecturer : lecturers) {
            dtos.add(fromEntity(lecturer));
        }
        return dtos;
    }
}
