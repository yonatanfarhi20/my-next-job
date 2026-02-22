package com.mynextjob.Backend.repositories;

import com.mynextjob.Backend.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    // למציאת כישור ספציפי (שימושי ב-Mappers)
    Optional<Skill> findByNameIgnoreCase(String name);

    // בדיקה האם כישור קיים לפני הוספה
    boolean existsByNameIgnoreCase(String name);

    // שליפת רשימת כישורים לפי קטגוריה (למשל: כל כישורי ה-Frontend)
    List<Skill> findAllByCategoryIgnoreCase(String category);

    // חיפוש חלקי לצורך Autocomplete ב-Frontend (למשל: המשתמש הקליד "Jav")
    List<Skill> findByNameContainingIgnoreCase(String name);

    // שליפת קבוצת כישורים לפי רשימת מזהים (יעיל מאוד ליצירת משרה חדשה)
    Set<Skill> findAllByIdIn(Set<Long> ids);

    // שאילתה מותאמת מציאת הכישורים המבוקשים ביותר (לפי כמות המשרות שדורשות אותם)
    @Query("SELECT s FROM Skill s JOIN s.jobs j GROUP BY s ORDER BY COUNT(j) DESC")
    List<Skill> findTrendingSkills();
}