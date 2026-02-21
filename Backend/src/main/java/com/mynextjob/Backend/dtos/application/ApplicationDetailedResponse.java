package com.mynextjob.Backend.dtos.application;

import com.mynextjob.Backend.enums.ApplicationStatus;
import com.mynextjob.Backend.dtos.job.JobShortResponse;
import com.mynextjob.Backend.dtos.user.responses.UserResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "פרטי מועמדות מורחבים הכוללים מידע מלא על המועמד והמשרה")
public class ApplicationDetailedResponse {

    @Schema(description = "מזהה ייחודי של המועמדות", example = "501", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "פרטי המשרה המקושרת")
    private JobShortResponse job;

    @Schema(description = "פרופיל המועמד המלא (פרטי קשר וזהות)")
    private UserResponse candidate;

    @Schema(
            description = "המכתב המקדים שצורף על ידי המועמד בזמן ההגשה",
            example = "אני מביא איתי 5 שנות ניסיון בפיתוח מערכות מבוזרות..."
    )
    private String coverLetter;

    @Schema(
            description = "הסטטוס הנוכחי בתהליך הגיוס",
            example = "INTERVIEW",
            allowableValues = {"PENDING", "REVIEWING", "INTERVIEW", "OFFER", "REJECTED", "HIRED"}
    )
    private ApplicationStatus status;

    @Schema(description = "תאריך ושעת הגשת המועמדות המקורית", example = "2026-02-22T08:00:00", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime appliedAt;

    @Schema(description = "תאריך העדכון האחרון (שינוי סטטוס)", example = "2026-02-23T10:30:00", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updatedAt;
}