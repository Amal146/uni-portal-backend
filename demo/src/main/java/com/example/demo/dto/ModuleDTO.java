package com.example.demo.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {

    private String id;
    private String name;
    private String shortName;
    private String programmeId;
    private String type;
    private Integer totalEcts;
    private String coordinatorId;
}