package com.example.demo.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Schedule;

import lombok.*;

// ScheduleDTO with flat fields
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private String id;
    private String courseId;
    private String semesterId;
    private LocalDate date;
    private String dayOfWeek;
    private String timeSlot;
    private String room;
    
    // Static method to convert from Entity to DTO
    public static ScheduleDTO fromEntity(Schedule schedule) {
        if (schedule == null) return null;
        
        ScheduleDTO dto = new ScheduleDTO();
        dto.setId(schedule.getId());
        dto.setCourseId(schedule.getCourse() != null ? schedule.getCourse().getId() : null);
        dto.setSemesterId(schedule.getSemester() != null ? schedule.getSemester().getId() : null);
        dto.setDate(schedule.getDate());
        dto.setDayOfWeek(schedule.getDayOfWeek() != null ? schedule.getDayOfWeek().name() : null);
        dto.setTimeSlot(schedule.getTimeSlot());
        dto.setRoom(schedule.getRoom());
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<ScheduleDTO> fromEntities(List<Schedule> schedules) {
        if (schedules == null) return new ArrayList<>();
        List<ScheduleDTO> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(fromEntity(schedule));
        }
        return dtos;
    }
}
