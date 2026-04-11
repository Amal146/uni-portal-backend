package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThesisPrerequisiteDTO {

    private String id;
    private String programmeId;
    private String moduleId;
}
