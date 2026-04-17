package com.example.demo.repository;

import com.example.demo.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, String> {
    
    // Find modules by programme id (programme is an object, so use programme.id)
    List<Module> findByProgrammeId(String programmeId);
    
    // Find modules by coordinator id (coordinator is a Lecturer object)
    List<Module> findByCoordinatorId(String lecturerId);
    
    // Find modules by type (type is now a String, not ModuleType enum)
    List<Module> findByType(String type);
    
    // Search modules by name, shortName, or type
    @Query("SELECT m FROM Module m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(m.shortName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(m.type) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Module> searchModules(@Param("keyword") String keyword);
    
    // Find modules by total ECTS range
    List<Module> findByTotalEctsBetween(Integer minEcts, Integer maxEcts);
    
    // Find modules with no coordinator assigned
    List<Module> findByCoordinatorIsNull();
    
    // Find modules by coordinator id and type
    List<Module> findByCoordinatorIdAndType(String lecturerId, String type);
    
    // Count modules by type
    @Query("SELECT m.type, COUNT(m) FROM Module m GROUP BY m.type")
    List<Object[]> countModulesByType();
    
    // Get total ECTS sum for a programme (using totalEcts field)
    @Query("SELECT SUM(m.totalEcts) FROM Module m WHERE m.programme.id = :programmeId")
    Long sumTotalEctsByProgrammeId(@Param("programmeId") String programmeId);
    
    // Find modules by programme id and type
    List<Module> findByProgrammeIdAndType(String programmeId, String type);
    
    // Find modules that have courses
    @Query("SELECT DISTINCT m FROM Module m JOIN m.courses c")
    List<Module> findModulesWithCourses();
    
    // Find modules that have exams
    @Query("SELECT DISTINCT m FROM Module m JOIN m.exams e")
    List<Module> findModulesWithExams();
}