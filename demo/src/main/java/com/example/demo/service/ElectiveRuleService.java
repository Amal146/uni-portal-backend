package com.example.demo.service;

import com.example.demo.dto.ElectiveRuleDTO;
import com.example.demo.model.ElectiveRule;
import com.example.demo.model.Programme;
import com.example.demo.repository.ElectiveRuleRepository;
import com.example.demo.repository.ProgrammeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ElectiveRuleService {
    private final ElectiveRuleRepository electiveRuleRepository;
    private final ProgrammeRepository programmeRepository;

    public List<ElectiveRuleDTO> getAllElectiveRules() {
        return ElectiveRuleDTO.fromEntities(electiveRuleRepository.findAll());
    }

    public ElectiveRuleDTO getElectiveRuleById(String id) {
        ElectiveRule electiveRule = electiveRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ElectiveRule not found with id: " + id));
        return ElectiveRuleDTO.fromEntity(electiveRule);
    }

    @Transactional
    public ElectiveRuleDTO createElectiveRule(ElectiveRuleDTO electiveRuleDTO) {
        ElectiveRule electiveRule = convertToEntity(electiveRuleDTO);
        if (electiveRule.getId() == null) {
            electiveRule.setId(java.util.UUID.randomUUID().toString());
        }
        ElectiveRule saved = electiveRuleRepository.save(electiveRule);
        return ElectiveRuleDTO.fromEntity(saved);
    }

    @Transactional
    public ElectiveRuleDTO updateElectiveRule(String id, ElectiveRuleDTO ruleDetailsDTO) {
        ElectiveRule rule = getElectiveRuleEntityById(id);
        updateElectiveRuleEntity(rule, ruleDetailsDTO);
        ElectiveRule updated = electiveRuleRepository.save(rule);
        return ElectiveRuleDTO.fromEntity(updated);
    }

    @Transactional
    public void deleteElectiveRule(String id) {
        electiveRuleRepository.deleteById(id);
    }

    public List<ElectiveRuleDTO> getRulesByProgrammeId(String programmeId) {
        return ElectiveRuleDTO.fromEntities(electiveRuleRepository.findByProgrammeId(programmeId));
    }

    public List<ElectiveRuleDTO> getRulesByProgrammeIdAndType(String programmeId, String type) {
        ElectiveRule.ElectiveType typeEnum = ElectiveRule.ElectiveType.valueOf(type);
        return ElectiveRuleDTO.fromEntities(electiveRuleRepository.findByProgrammeIdAndType(programmeId, typeEnum));
    }
    
    // Helper methods for internal use
    private ElectiveRule getElectiveRuleEntityById(String id) {
        return electiveRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ElectiveRule not found with id: " + id));
    }
    
    private ElectiveRule convertToEntity(ElectiveRuleDTO dto) {
        ElectiveRule electiveRule = new ElectiveRule();
        electiveRule.setId(dto.getId());
        electiveRule.setTotalSlots(dto.getTotalSlots());
        electiveRule.setEctsPerSlot(dto.getEctsPerSlot());
        electiveRule.setRequiredEcts(dto.getRequiredEcts());
        electiveRule.setMaxSubstituteEcts(dto.getMaxSubstituteEcts());
        
        // Set Programme if programmeId is provided
        if (dto.getProgrammeId() != null) {
            Programme programme = programmeRepository.findById(dto.getProgrammeId())
                    .orElseThrow(() -> new RuntimeException("Programme not found with id: " + dto.getProgrammeId()));
            electiveRule.setProgramme(programme);
        }
        
        // Set Type if type is provided
        if (dto.getType() != null) {
            electiveRule.setType(ElectiveRule.ElectiveType.valueOf(dto.getType()));
        }
        
        return electiveRule;
    }
    
    private void updateElectiveRuleEntity(ElectiveRule electiveRule, ElectiveRuleDTO dto) {
        electiveRule.setTotalSlots(dto.getTotalSlots());
        electiveRule.setEctsPerSlot(dto.getEctsPerSlot());
        electiveRule.setRequiredEcts(dto.getRequiredEcts());
        electiveRule.setMaxSubstituteEcts(dto.getMaxSubstituteEcts());
        
        // Update Programme if programmeId is provided
        if (dto.getProgrammeId() != null) {
            Programme programme = programmeRepository.findById(dto.getProgrammeId())
                    .orElseThrow(() -> new RuntimeException("Programme not found with id: " + dto.getProgrammeId()));
            electiveRule.setProgramme(programme);
        }
        
        // Update Type if type is provided
        if (dto.getType() != null) {
            electiveRule.setType(ElectiveRule.ElectiveType.valueOf(dto.getType()));
        }
    }
}