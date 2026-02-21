package com.mynextjob.Backend.dtos.job;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "גרסה מקוצרת של פרטי משרה - מיועדת לתצוגה ברשימות וחיפושים (Optimization)")
public record JobShortResponse(

        @Schema(description = "מזהה ייחודי של המשרה", example = "202", accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @Schema(description = "כותרת המשרה", example = "Senior Java Developer")
        String title,

        @Schema(description = "שם החברה המפרסמת", example = "Google")
        String companyName,

        @Schema(description = "מיקום המשרה", example = "Tel Aviv / Remote")
        String location,

        @Schema(description = "טווח שכר תחתון (אופציונלי לתצוגה מקדימה)", example = "28000.0")
        Double minSalary,

        @Schema(description = "טווח שכר עליון (אופציונלי לתצוגה מקדימה)", example = "38000.0")
        Double maxSalary,

        @Schema(description = "קטגוריית התחום", example = "Software Engineering")
        String category
) {}