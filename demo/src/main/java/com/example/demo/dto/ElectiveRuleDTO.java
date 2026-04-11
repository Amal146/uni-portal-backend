package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectiveRuleDTO {

    private String id;
    private String programmeId;
    private String type;
    private Integer totalSlots;
    private Integer ectsPerSlot;
    private Integer requiredEcts;
    private Integer maxSubstituteEcts;
}
