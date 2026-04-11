package com.example.demo.service;

import com.example.demo.model.SemesterMeta;
import com.example.demo.repository.SemesterMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SemesterMetaService {
    
    @Autowired
    private SemesterMetaRepository semesterMetaRepository;
    
    public List<SemesterMeta> getAllSemesters() {
        return semesterMetaRepository.findAll();
    }
    
    public Optional<SemesterMeta> getSemesterById(String id) {
        return semesterMetaRepository.findById(id);
    }
    
    public List<SemesterMeta> getSemestersBySeason(SemesterMeta.Season season) {
        return semesterMetaRepository.findBySeason(season);
    }
    
    public List<SemesterMeta> getSemestersByYear(Integer calYear) {
        return semesterMetaRepository.findByCalYear(calYear);
    }
    
    public List<SemesterMeta> getActiveSemesters() {
        return semesterMetaRepository.findByStatus(SemesterMeta.SemesterStatus.current);
    }
    
    @Transactional
    public SemesterMeta createSemester(SemesterMeta semester) {
        return semesterMetaRepository.save(semester);
    }
    
    @Transactional
    public SemesterMeta updateSemester(String id, SemesterMeta semesterDetails) {
        SemesterMeta semester = semesterMetaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Semester not found"));
        
        if (semesterDetails.getName() != null) semester.setName(semesterDetails.getName());
        if (semesterDetails.getLabel() != null) semester.setLabel(semesterDetails.getLabel());
        if (semesterDetails.getSeason() != null) semester.setSeason(semesterDetails.getSeason());
        if (semesterDetails.getCalYear() != null) semester.setCalYear(semesterDetails.getCalYear());
        if (semesterDetails.getStart() != null) semester.setStart(semesterDetails.getStart());
        if (semesterDetails.getEnd() != null) semester.setEnd(semesterDetails.getEnd());
        if (semesterDetails.getStatus() != null) semester.setStatus(semesterDetails.getStatus());
        
        return semesterMetaRepository.save(semester);
    }
    
    @Transactional
    public void deleteSemester(String id) {
        semesterMetaRepository.deleteById(id);
    }
}