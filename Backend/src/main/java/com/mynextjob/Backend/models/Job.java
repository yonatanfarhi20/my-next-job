package com.mynextjob.Backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity @Table(name = "jobs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Job {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "חובה להזין כותרת למשרה")
    @Size(min = 2, max = 100, message = "כותרת המשרה חייבת להיות בין 2 ל-100 תווים")
    private String title;

    @NotNull(message = "חובה לשייך את המשרה לחברה")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @NotBlank(message = "חובה להזין מיקום (עיר או אזור)")
    private String location;

    @NotBlank(message = "חובה להזין תיאור משרה")
    @Size(min = 10, message = "תיאור המשרה חייב להכיל לפחות 10 תווים")
    private String description;


    @PositiveOrZero(message = "שכר מינימום לא יכול להיות מספר שלילי")
    private Double minSalary;

    @PositiveOrZero(message = "שכר מקסימום לא יכול להיות מספר שלילי")
    private Double maxSalary;

    @AssertTrue(message = "שכר מקסימום חייב להיות גבוה משכר מינימום")
    public boolean isSalaryRangeValid(){
        if (minSalary == null || maxSalary == null) return true;
        return maxSalary > minSalary;
    }

    @NotBlank(message = "חובה לבחור קטגוריה למשרה")
    private String category;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); updatedAt = LocalDateTime.now(); }

    @PreUpdate
    protected void onUpdate() { updatedAt = LocalDateTime.now(); }

    @ManyToMany
    @JoinTable(
            name = "job_skills",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();
}