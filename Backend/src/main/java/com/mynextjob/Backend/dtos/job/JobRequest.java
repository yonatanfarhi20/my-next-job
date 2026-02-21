package com.mynextjob.Backend.dtos.job;

import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class JobRequest {

    @NotBlank(message = "חובה להזין כותרת למשרה")
    @Size(min = 2, max = 100, message = "כותרת המשרה חייבת להיות בין 2 ל-100 תווים")
    private String title;

    @NotNull(message = "חובה לשייך את המשרה לחברה")
    private Long companyId;

    @NotBlank(message = "חובה להזין מיקום (עיר או אזור)")
    private String location;

    @NotBlank(message = "חובה להזין תיאור משרה")
    @Size(min = 10, message = "תיאור המשרה חייב להכיל לפחות 10 תווים")
    private String description;

    @PositiveOrZero(message = "שכר מינימום לא יכול להיות מספר שלילי")
    private Double minSalary;

    @PositiveOrZero(message = "שכר מקסימום לא יכול להיות מספר שלילי")
    private Double maxSalary;

    @NotBlank(message = "חובה לבחור קטגוריה למשרה")
    private String category;

    private Set<Long> skillIds;

    // ולידציה מותאמת אישית ברמת ה-DTO
    @AssertTrue(message = "שכר מקסימום חייב להיות גבוה או שווה לשכר מינימום")
    public boolean isSalaryRangeValid() {
        if (minSalary == null || maxSalary == null) return true;
        return maxSalary >= minSalary;
    }
}