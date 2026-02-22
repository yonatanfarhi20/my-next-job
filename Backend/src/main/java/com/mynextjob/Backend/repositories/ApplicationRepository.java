package com.mynextjob.Backend.repositories;

import com.mynextjob.Backend.models.Application;
import com.mynextjob.Backend.enums.ApplicationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    // מציאת הגשה לפי מזהה מועמד ומזהה משרה (שימוש ב-candidate_Id כי זה שם השדה ב-Entity)
    Optional<Application> findByCandidate_IdAndJob_Id(Long candidateId, Long jobId);

    // בדיקה מהירה למניעת כפילויות
    boolean existsByCandidate_IdAndJob_Id(Long candidateId, Long jobId);

    // שליפת כל ההגשות של מועמד ספציפי למסך "ההגשות שלי"
    List<Application> findAllByCandidate_IdOrderByAppliedAtDesc(Long candidateId);

    // שליפת מועמדים למשרה ספציפית עם דפידוף (עבור המעסיק)
    Page<Application> findAllByJobId(Long jobId, Pageable pageable);

    // סינון מועמדים למשרה לפי סטטוס
    List<Application> findAllByJobIdAndStatus(Long jobId, ApplicationStatus status);

    // סטטיסטיקה: ספירת מועמדים למשרה
    long countByJobId(Long jobId);

    // שאילתת אגרגציה לסטטיסטיקות בדשבורד המעסיק
    @Query("SELECT a.status, COUNT(a) FROM Application a WHERE a.job.id = :jobId GROUP BY a.status")
    List<Object[]> countApplicationsByStatusForJob(@Param("jobId") Long jobId);
}