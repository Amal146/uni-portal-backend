package com.example.demo.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Holiday;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HolidayDTO {
    private String id;
    private String type;
    private String title;
    private LocalDate date;
    private String description;
    private String semesterId;
    private LocalDate time;
    private String room;
    private String courseId;
    private String examId;
    
    // Static method to convert from Entity to DTO
    public static HolidayDTO fromEntity(Holiday holiday) {
        if (holiday == null) return null;
        
        HolidayDTO dto = new HolidayDTO();
        dto.setId(holiday.getId());
        dto.setType(holiday.getType() != null ? holiday.getType().name() : null);
        dto.setTitle(holiday.getTitle());
        dto.setDate(holiday.getDate());
        dto.setDescription(holiday.getDescription());
        dto.setSemesterId(holiday.getSemester() != null ? holiday.getSemester().getId() : null);
        dto.setTime(holiday.getTime());
        dto.setRoom(holiday.getRoom());
        dto.setCourseId(holiday.getCourseId());
        dto.setExamId(holiday.getExamId());
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<HolidayDTO> fromEntities(List<Holiday> holidays) {
        if (holidays == null) return new ArrayList<>();
        List<HolidayDTO> dtos = new ArrayList<>();
        for (Holiday holiday : holidays) {
            dtos.add(fromEntity(holiday));
        }
        return dtos;
    }
}
