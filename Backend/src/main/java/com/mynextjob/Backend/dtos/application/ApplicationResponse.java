package com.mynextjob.Backend.dtos.application;

import com.mynextjob.Backend.enums.ApplicationStatus;
import com.mynextjob.Backend.dtos.job.JobShortResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "פרטי הגשת מועמדות המוחזרים מהמערכת (תצוגת רשימה)")
public class ApplicationResponse {

    @Schema(description = "מזהה ייחודי של הגשת המועמדות", example = "501", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "פרטי המשרה שאליה הוגשה המועמדות (בפורמט מקוצר)")
    private JobShortResponse job;

    @Schema(description = "השם המלא של המועמד", example = "יוסי כהן")
    private String candidateName;

    @Schema(
            description = "הסטטוס הנוכחי של תהליך הגיוס",
            example = "PENDING",
            allowableValues = {"PENDING", "REVIEWING", "INTERVIEW", "OFFER", "REJECTED", "HIRED"}
    )
    private ApplicationStatus status;

    @Schema(description = "תאריך ושעת הגשת המועמדות", example = "2026-02-22T10:00:00", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime appliedAt;
}