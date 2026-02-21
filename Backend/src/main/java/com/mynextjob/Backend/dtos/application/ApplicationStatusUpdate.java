package com.mynextjob.Backend.dtos.application;

import com.mynextjob.Backend.enums.ApplicationStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "בקשה לעדכון סטטוס מועמדות (עבור מעסיקים)")
public class ApplicationStatusUpdate {

    @Schema(
            description = "הסטטוס החדש של המועמדות",
            example = "INTERVIEW",
            allowableValues = {"PENDING", "REVIEWING", "INTERVIEW", "OFFER", "REJECTED", "HIRED"},
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "חובה לציין סטטוס חדש")
    private ApplicationStatus status;
}