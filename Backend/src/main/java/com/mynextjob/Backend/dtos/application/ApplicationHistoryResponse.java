package com.mynextjob.Backend.dtos.application;

import com.mynextjob.Backend.enums.ApplicationStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "תיעוד היסטוריית שינויי סטטוס של מועמדות (Audit Trail)")
public record ApplicationHistoryResponse(

        @Schema(
                description = "הסטטוס שאליו שונתה המועמדות",
                example = "REVIEWING",
                allowableValues = {"PENDING", "REVIEWING", "INTERVIEW", "OFFER", "REJECTED", "HIRED"}
        )
        ApplicationStatus status,

        @Schema(
                description = "תאריך ושעת ביצוע השינוי",
                example = "2026-02-22T15:45:00",
                accessMode = Schema.AccessMode.READ_ONLY
        )
        LocalDateTime changedAt
) {}