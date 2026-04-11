package com.example.demo.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private String id;
    private String courseNumber;
    private String name;
    private String shortName;
    private String type;
    private String moduleId;
    private String programmeId;
    private String language;
    private String season;
    private String description;
    private String taughtUnits;
    private String privateStudyTime;
    private Boolean thesisPrereq;
    private String moodleUrl;
    private String coordinatorId;
    private String category;
}