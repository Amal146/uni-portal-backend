package com.example.demo.dto;



import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammeDTO {

    private String id;
    private String name;
    private String shortName;
    private String degree;
    private Integer totalEcts;
    private Integer standardSems;
    private LocalDate validFrom;
    private Integer thesisEcts;
    private Integer thesisMinEcts;
}