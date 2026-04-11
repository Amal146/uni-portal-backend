package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseLecturerDTO {

    private String id;
    private String courseId;
    private String lecturerId;
    private String role;
}