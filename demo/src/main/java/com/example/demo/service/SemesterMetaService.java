package com.example.demo.service;

import com.example.demo.model.SemesterMeta;
import com.example.demo.repository.SemesterMetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SemesterMetaService {
    private final SemesterMetaRepository semesterMetaRepository;

    public List<SemesterMeta> getAllSemesterMetas() {
        return semesterMetaRepository.findAll();
    }

    public SemesterMeta getSemesterMetaById(String id) {
        return semesterMetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SemesterMeta not found with id: " + id));
    }

    @Transactional
    public SemesterMeta createSemesterMeta(SemesterMeta semesterMeta) {
        if (semesterMeta.getId() == null) {
            semesterMeta.setId(UUID.randomUUID().toString());
        }
        return semesterMetaRepository.save(semesterMeta);
    }

    @Transactional
    public SemesterMeta updateSemesterMeta(String id, SemesterMeta metaDetails) {
        SemesterMeta meta = getSemesterMetaById(id);
        meta.setName(metaDetails.getName());
        meta.setShortLabel(metaDetails.getShortLabel());
        meta.setLabel(metaDetails.getLabel());
        meta.setSeason(metaDetails.getSeason());
        meta.setCalYear(metaDetails.getCalYear());
        meta.setStart(metaDetails.getStart());
        meta.setEnd(metaDetails.getEnd());
        meta.setExamPeriodStart(metaDetails.getExamPeriodStart());
        meta.setExamPeriodEnd(metaDetails.getExamPeriodEnd());
        meta.setStatus(metaDetails.getStatus());
        return semesterMetaRepository.save(meta);
    }

    @Transactional
    public void deleteSemesterMeta(String id) {
        semesterMetaRepository.deleteById(id);
    }

    public List<SemesterMeta> getSemesterMetasBySeason(SemesterMeta.Season season) {
        return semesterMetaRepository.findBySeason(season);
    }

    public List<SemesterMeta> getSemesterMetasByCalYear(Integer calYear) {
        return semesterMetaRepository.findByCalYear(calYear);
    }

    public List<SemesterMeta> getSemesterMetasByStatus(SemesterMeta.SemesterStatus status) {
        return semesterMetaRepository.findByStatus(status);
    }

    public SemesterMeta getSemesterMetaByLabelAndCalYear(String label, Integer calYear) {
        return semesterMetaRepository.findByLabelAndCalYear(label, calYear)
                .orElseThrow(() -> new RuntimeException("SemesterMeta not found"));
    }
}