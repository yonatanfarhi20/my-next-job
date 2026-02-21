package com.mynextjob.Backend.dtos.company;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "פרטי חברה מלאים המוחזרים מהמערכת")
public class CompanyResponse {

    @Schema(description = "מזהה ייחודי של החברה", example = "10", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "שם החברה הרשמי", example = "Google Israel")
    private String name;

    @Schema(description = "כתובת אתר האינטרנט של החברה", example = "https://about.google")
    private String website;

    @Schema(description = "תעשייה או מגזר עסקי", example = "Information Technology")
    private String industry;

    @Schema(description = "תאריך הצטרפות החברה למערכת", example = "2026-01-15T09:00:00", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime createdAt;
}