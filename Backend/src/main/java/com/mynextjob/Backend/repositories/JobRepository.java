package com.mynextjob.Backend.repositories;

import com.mynextjob.Backend.models.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    // שליפת כל המשרות של חברה ספציפית
    List<Job> findAllByCompanyId(Long companyId);

    // חיפוש לפי קטגוריה עם תמיכה בדפידוף (Pagination)
    Page<Job> findAllByCategoryIgnoreCase(String category, Pageable pageable);

    // חיפוש לפי מיקום (חיפוש חלקי - למשל "תל" ימצא את "תל אביב")
    Page<Job> findAllByLocationContainingIgnoreCase(String location, Pageable pageable);

    // שאילתת סינון מתקדמת (שכר + קטגוריה)
    // משתמשים ב-JPQL כדי לוודא ששכר המינימום של המשרה גבוה או שווה למה שהמשתמש ביקש
    @Query("SELECT j FROM Job j WHERE j.category = :category AND j.minSalary >= :minSalary")
    Page<Job> filterBySalaryAndCategory(
            @Param("category") String category,
            @Param("minSalary") Double minSalary,
            Pageable pageable
    );

    // שליפת המשרות החדשות ביותר (לדף הבית)
    List<Job> findTop5ByOrderByCreatedAtDesc();
}