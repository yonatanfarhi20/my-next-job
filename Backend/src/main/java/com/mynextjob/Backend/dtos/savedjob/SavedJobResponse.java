package com.mynextjob.Backend.dtos.savedjob;

import com.mynextjob.Backend.dtos.job.JobShortResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "פרטי משרה שנשמרה במועדפים על ידי המשתמש")
public class SavedJobResponse {

    @Schema(description = "מזהה ייחודי של רשומת השמירה", example = "45", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "פרטי המשרה השמורה בפורמט מקוצר (כותרת, חברה, מיקום וכו')")
    private JobShortResponse job;

    @Schema(description = "תאריך ושעת שמירת המשרה", example = "2026-02-22T14:30:00", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime savedAt;
}