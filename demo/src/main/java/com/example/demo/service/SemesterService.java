package com.example.demo.service;

import com.example.demo.model.Semester;
import com.example.demo.repository.SemesterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SemesterService {

    private final SemesterRepository semesterRepository;

    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    public Semester getSemesterById(String id) {
        return semesterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Semester not found with id: " + id));
    }

    @Transactional
    public Semester createSemester(Semester semester) {
        if (semester.getId() == null) {
            semester.setId(UUID.randomUUID().toString());
        }
        return semesterRepository.save(semester);
    }

    @Transactional
    public Semester updateSemester(String id, Semester details) {

        Semester semester = getSemesterById(id);

        semester.setName(details.getName());
        semester.setShortLabel(details.getShortLabel());
        semester.setLabel(details.getLabel());
        semester.setSeason(details.getSeason());
        semester.setCalYear(details.getCalYear());
        semester.setStart(details.getStart());
        semester.setEnd(details.getEnd());
        semester.setExamPeriodStart(details.getExamPeriodStart());
        semester.setExamPeriodEnd(details.getExamPeriodEnd());
        semester.setStatus(details.getStatus());

        return semesterRepository.save(semester);
    }

    @Transactional
    public void deleteSemester(String id) {
        semesterRepository.deleteById(id);
    }

    public List<Semester> getSemestersBySeason(Semester.Season season) {
        return semesterRepository.findBySeason(season);
    }

    public List<Semester> getSemestersByCalYear(Integer calYear) {
        return semesterRepository.findByCalYear(calYear);
    }

    public List<Semester> getSemestersByStatus(String status) {
        return semesterRepository.findByStatus(status);
    }

    public Semester getSemesterByLabelAndCalYear(String label, Integer calYear) {
        return semesterRepository.findByLabelAndCalYear(label, calYear)
                .orElseThrow(() -> new RuntimeException("Semester not found"));
    }
}