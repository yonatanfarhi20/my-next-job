package com.mynextjob.Backend.dtos.application;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "בקשה להגשת מועמדות למשרה (Submit Application)")
public class ApplicationRequest {

    @Schema(
            description = "המזהה הייחודי (ID) של המשרה אליה מוגשת המועמדות",
            example = "202",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "חובה לציין מזהה משרה")
    private Long jobId;

    @Schema(
            description = "מכתב מקדים או הערה מהמועמד למעסיק (אופציונלי)",
            example = "אני מפתח Java עם תשוקה למערכות Backend מורכבות, אשמח להתראיין.",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private String coverLetter;
}