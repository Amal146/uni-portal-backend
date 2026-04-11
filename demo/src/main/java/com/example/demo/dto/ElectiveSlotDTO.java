package com.example.demo.dto;


import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectiveSlotDTO {

    private String id;
    private String studentId;
    private String type;
    private String label;
    private Integer slotNumber;
    private Integer plannedSlot;
    private String plannedSemesterId;
    private String selectedCourseId;
    private String status;
}
