package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Exam;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamDTO {
    private String id;
    private String courseId;
    private String moduleId;
    private String semesterId;
    private String type;
    private LocalDate date;
    private String time;
    private Integer duration;
    private String room;
    
    // Static method to convert from Entity to DTO
    public static ExamDTO fromEntity(Exam exam) {
        if (exam == null) return null;
        
        ExamDTO dto = new ExamDTO();
        dto.setId(exam.getId());
        dto.setCourseId(exam.getCourse() != null ? exam.getCourse().getId() : null);
        dto.setModuleId(exam.getModule() != null ? exam.getModule().getId() : null);
        dto.setSemesterId(exam.getSemester() != null ? exam.getSemester().getId() : null);
        dto.setType(exam.getType() != null ? exam.getType().name() : null);
        dto.setDate(exam.getDate());
        dto.setTime(exam.getTime());
        dto.setDuration(exam.getDuration());
        dto.setRoom(exam.getRoom());
        
        return dto;
    }
    
    // Method to convert list of entities to list of DTOs
    public static List<ExamDTO> fromEntities(List<Exam> exams) {
        if (exams == null) return new ArrayList<>();
        List<ExamDTO> dtos = new ArrayList<>();
        for (Exam exam : exams) {
            dtos.add(fromEntity(exam));
        }
        return dtos;
    }
}
