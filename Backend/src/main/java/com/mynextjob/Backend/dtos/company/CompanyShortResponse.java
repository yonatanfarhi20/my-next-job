package com.mynextjob.Backend.dtos.company;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "תצוגה מקוצרת של פרטי חברה - לשימוש ברשימות וחיפושים מהירים")
public record CompanyShortResponse(

        @Schema(description = "מזהה ייחודי של החברה", example = "10", accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @Schema(description = "שם החברה", example = "Google")
        String name,

        @Schema(description = "תעשייה/תחום פעילות עיקרי", example = "High Tech / Software")
        String industry
) {}