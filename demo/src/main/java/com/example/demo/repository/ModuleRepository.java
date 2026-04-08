package com.example.demo.repository;

import com.example.demo.model.Module;
import com.example.demo.model.Module.ModuleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ModuleRepository extends JpaRepository<Module, String> {
    
    List<Module> findByProgrammeId(String programmeId);
    
    // Fixed: Use nested property for moduleCoordinator id
    List<Module> findByModuleCoordinatorId(String lecturerId);
    
    // Add missing methods referenced in your service
    Optional<Module> findByModuleCode(String moduleCode);
    
    List<Module> findByType(ModuleType type);
    
    @Query("SELECT SUM(m.ects) FROM Module m WHERE m.programme.id = :programmeId")
    Long sumEctsByProgrammeId(@Param("programmeId") String programmeId);
    
    @Query("SELECT m FROM Module m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(m.moduleCode) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(m.content) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Module> searchModules(@Param("keyword") String keyword);
}