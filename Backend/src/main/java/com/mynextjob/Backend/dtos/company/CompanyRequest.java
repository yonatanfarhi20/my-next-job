package com.mynextjob.Backend.dtos.company;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "בקשה ליצירה או עדכון של פרטי חברה במערכת")
public class CompanyRequest {

    @Schema(
            description = "שם החברה המלא",
            example = "OpenAI Israel",
            minLength = 2,
            maxLength = 100,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "חובה להזין את שם החברה")
    @Size(min = 2, max = 100, message = "שם החברה חייב להיות בין 2 ל-100 תווים")
    private String name;

    @Schema(
            description = "כתובת אתר האינטרנט הרשמי של החברה (פורמט URL תקין)",
            example = "https://www.openai.com",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @URL(message = "כתובת אתר האינטרנט אינה תקינה")
    @NotBlank(message = "חובה להזין כתובת אתר אינטרנט")
    private String website;

    @Schema(
            description = "תחום הפעילות המרכזי של החברה",
            example = "Artificial Intelligence",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "חובה להזין את תחום הפעילות של החברה")
    private String industry;
}