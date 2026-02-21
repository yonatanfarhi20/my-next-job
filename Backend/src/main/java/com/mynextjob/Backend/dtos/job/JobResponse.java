package com.mynextjob.Backend.dtos.job;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.Set;

@Schema(description = "פרטי משרה מלאים המוחזרים מהמערכת")
public record JobResponse(

        @Schema(description = "מזהה ייחודי של המשרה", example = "202", accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @Schema(description = "כותרת המשרה", example = "Senior Java Developer")
        String title,

        @Schema(description = "מזהה החברה המפרסמת", example = "10")
        Long companyId,

        @Schema(description = "שם החברה המפרסמת", example = "Google")
        String companyName,

        @Schema(description = "מיקום המשרה", example = "Tel Aviv / Remote")
        String location,

        @Schema(description = "תיאור המשרה המלא", example = "אנחנו מחפשים מפתח מוכשר להובלת צוות...")
        String description,

        @Schema(description = "שכר מינימום", example = "28000.0")
        Double minSalary,

        @Schema(description = "שכר מקסימום", example = "38000.0")
        Double maxSalary,

        @Schema(description = "קטגוריית התחום", example = "Software Engineering")
        String category,

        @Schema(description = "רשימת שמות הכישורים הנדרשים (במקום מזהים)", example = "[\"Java\", \"Spring Boot\", \"Docker\"]")
        Set<String> skillNames,

        @Schema(description = "זמן העדכון האחרון של המשרה", example = "2026-02-22T12:00:00", accessMode = Schema.AccessMode.READ_ONLY)
        LocalDateTime updatedAt
) {}