package com.mynextjob.Backend.dtos.job;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "בקשה ליצירה או עדכון של משרת דרושים")
public class JobRequest {

    @Schema(description = "כותרת המשרה", example = "Senior Java Developer", minLength = 2, maxLength = 100)
    @NotBlank(message = "חובה להזין כותרת למשרה")
    @Size(min = 2, max = 100, message = "כותרת המשרה חייבת להיות בין 2 ל-100 תווים")
    private String title;

    @Schema(description = "מזהה החברה המפרסמת (ID)", example = "10")
    @NotNull(message = "חובה לשייך את המשרה לחברה")
    private Long companyId;

    @Schema(description = "מיקום המשרה (עיר/אזור או Remote)", example = "Tel Aviv / Remote")
    @NotBlank(message = "חובה להזין מיקום (עיר או אזור)")
    private String location;

    @Schema(description = "תיאור מלא של דרישות התפקיד והאחריות", example = "אנחנו מחפשים מפתח Java עם ניסיון ב-Spring Boot...")
    @NotBlank(message = "חובה להזין תיאור משרה")
    @Size(min = 10, message = "תיאור המשרה חייב להכיל לפחות 10 תווים")
    private String description;

    @Schema(description = "טווח שכר תחתון (ברוטו)", example = "25000.0")
    @PositiveOrZero(message = "שכר מינימום לא יכול להיות מספר שלילי")
    private Double minSalary;

    @Schema(description = "טווח שכר עליון (ברוטו)", example = "35000.0")
    @PositiveOrZero(message = "שכר מקסימום לא יכול להיות מספר שלילי")
    private Double maxSalary;

    @Schema(description = "קטגוריית התחום", example = "Software Engineering")
    @NotBlank(message = "חובה לבחור קטגוריה למשרה")
    private String category;

    @Schema(description = "רשימת מזהי הכישורים הנדרשים למשרה", example = "[1, 5, 12]")
    private Set<Long> skillIds;

    @Schema(hidden = true) // מסתירים מהתיעוד כי זו לוגיקה פנימית בלבד
    @AssertTrue(message = "שכר מקסימום חייב להיות גבוה או שווה לשכר מינימום")
    public boolean isSalaryRangeValid() {
        if (minSalary == null || maxSalary == null) return true;
        return maxSalary >= minSalary;
    }
}