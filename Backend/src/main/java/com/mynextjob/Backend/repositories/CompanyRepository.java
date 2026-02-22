package com.mynextjob.Backend.repositories;

import com.mynextjob.Backend.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    // חיפוש לפי שם מדויק (למשל לוולידציה שחברה לא קיימת כבר)
    Optional<Company> findByNameIgnoreCase(String name);

    // בדיקה מהירה אם חברה קיימת לפי שם
    boolean existsByNameIgnoreCase(String name);

    // חיפוש חברות לפי תעשייה (Industry)
    List<Company> findAllByIndustryIgnoreCase(String industry);

    // שאילתה מותאמת (Custom Query) לחיפוש חופשי בשם החברה
    // משתמשים ב-JPQL כדי להבטיח ביצועים וגמישות
    @Query("SELECT c FROM Company c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Company> searchByName(@Param("keyword") String keyword);
}