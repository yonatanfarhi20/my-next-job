package com.mynextjob.Backend.dtos.savedjob;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "בקשה לשמירת משרה במועדפים עם אפשרות להערה אישית")
public class SavedJobRequest {

    @Schema(
            description = "המזהה הייחודי (ID) של המשרה שרוצים לשמור",
            example = "202",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "חובה לציין מזהה משרה")
    private Long jobId;

    @Schema(
            description = "הערה אישית שהמשתמש יכול להוסיף לעצמו על המשרה",
            example = "נראה מעניין, דורשים ניסיון ב-Spring",
            maxLength = 255,
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 255, message = "הערה אישית מוגבלת ל-255 תווים")
    private String note;
}