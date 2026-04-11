package com.example.demo.repository;

import com.example.demo.model.ElectiveSubstitutionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ElectiveSubstitutionRuleRepository extends JpaRepository<ElectiveSubstitutionRule, String> {
    List<ElectiveSubstitutionRule> findByElectiveRuleId(String electiveRuleId);
    List<ElectiveSubstitutionRule> findByProgrammeId(String programmeId);
}