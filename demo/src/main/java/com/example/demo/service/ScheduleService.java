package com.example.demo.service;

import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(String id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found with id: " + id));
    }

    @Transactional
    public Schedule createSchedule(Schedule schedule) {
        if (schedule.getId() == null) {
            schedule.setId(UUID.randomUUID().toString());
        }
        return scheduleRepository.save(schedule);
    }

    @Transactional
    public Schedule updateSchedule(String id, Schedule scheduleDetails) {
        Schedule schedule = getScheduleById(id);
        schedule.setCourse(scheduleDetails.getCourse());
        schedule.setSemester(scheduleDetails.getSemester());
        schedule.setDate(scheduleDetails.getDate());
        schedule.setDayOfWeek(scheduleDetails.getDayOfWeek());
        schedule.setTimeSlot(scheduleDetails.getTimeSlot());
        schedule.setRoom(scheduleDetails.getRoom());
        return scheduleRepository.save(schedule);
    }

    @Transactional
    public void deleteSchedule(String id) {
        scheduleRepository.deleteById(id);
    }

    public List<Schedule> getSchedulesByCourseId(String courseId) {
        return scheduleRepository.findByCourseId(courseId);
    }

    public List<Schedule> getSchedulesBySemesterId(String semesterId) {
        return scheduleRepository.findBySemesterId(semesterId);
    }

    public List<Schedule> getSchedulesBetweenDates(LocalDate startDate, LocalDate endDate) {
        return scheduleRepository.findSchedulesBetweenDates(startDate, endDate);
    }
}