package com.example.demo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
}