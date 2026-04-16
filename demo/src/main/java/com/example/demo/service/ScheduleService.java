package com.example.demo.service;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.model.Course;
import com.example.demo.model.Schedule;
import com.example.demo.model.Semester;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.repository.SemesterRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;



// Updated ScheduleService that returns DTOs
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final CourseRepository courseRepository;
    private final SemesterRepository semesterRepository;

    public List<ScheduleDTO> getAllSchedules() {
        return ScheduleDTO.fromEntities(scheduleRepository.findAll());
    }

    public ScheduleDTO getScheduleById(String id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found with id: " + id));
        return ScheduleDTO.fromEntity(schedule);
    }

    @Transactional
    public ScheduleDTO createSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = convertToEntity(scheduleDTO);
        if (schedule.getId() == null) {
            schedule.setId(java.util.UUID.randomUUID().toString());
        }
        Schedule saved = scheduleRepository.save(schedule);
        return ScheduleDTO.fromEntity(saved);
    }

    @Transactional
    public ScheduleDTO updateSchedule(String id, ScheduleDTO scheduleDetailsDTO) {
        Schedule schedule = getScheduleEntityById(id);
        updateScheduleEntity(schedule, scheduleDetailsDTO);
        Schedule updated = scheduleRepository.save(schedule);
        return ScheduleDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteSchedule(String id) {
        scheduleRepository.deleteById(id);
    }

    public List<ScheduleDTO> getSchedulesByCourseId(String courseId) {
        return ScheduleDTO.fromEntities(scheduleRepository.findByCourseId(courseId));
    }

    public List<ScheduleDTO> getSchedulesBySemesterId(String semesterId) {
        return ScheduleDTO.fromEntities(scheduleRepository.findBySemesterId(semesterId));
    }

    public List<ScheduleDTO> getSchedulesBetweenDates(LocalDate startDate, LocalDate endDate) {
        return ScheduleDTO.fromEntities(scheduleRepository.findSchedulesBetweenDates(startDate, endDate));
    }
    
    // Helper methods for internal use
    private Schedule getScheduleEntityById(String id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found with id: " + id));
    }
    
    private Schedule convertToEntity(ScheduleDTO dto) {
        Schedule schedule = new Schedule();
        schedule.setId(dto.getId());
        schedule.setDate(dto.getDate());
        schedule.setTimeSlot(dto.getTimeSlot());
        schedule.setRoom(dto.getRoom());
        
        // Set Course if courseId is provided
        if (dto.getCourseId() != null) {
            Course course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourseId()));
            schedule.setCourse(course);
        }
        
        // Set Semester if semesterId is provided
        if (dto.getSemesterId() != null) {
            Semester semester = semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id: " + dto.getSemesterId()));
            schedule.setSemester(semester);
        }
        
        // Set DayOfWeek if dayOfWeek is provided
        if (dto.getDayOfWeek() != null) {
            schedule.setDayOfWeek(Schedule.DayOfWeek.valueOf(dto.getDayOfWeek()));
        }
        
        return schedule;
    }
    
    private void updateScheduleEntity(Schedule schedule, ScheduleDTO dto) {
        schedule.setDate(dto.getDate());
        schedule.setTimeSlot(dto.getTimeSlot());
        schedule.setRoom(dto.getRoom());
        
        // Update Course if courseId is provided
        if (dto.getCourseId() != null) {
            Course course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourseId()));
            schedule.setCourse(course);
        }
        
        // Update Semester if semesterId is provided
        if (dto.getSemesterId() != null) {
            Semester semester = semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id: " + dto.getSemesterId()));
            schedule.setSemester(semester);
        }
        
        // Update DayOfWeek if dayOfWeek is provided
        if (dto.getDayOfWeek() != null) {
            schedule.setDayOfWeek(Schedule.DayOfWeek.valueOf(dto.getDayOfWeek()));
        }
    }
}
