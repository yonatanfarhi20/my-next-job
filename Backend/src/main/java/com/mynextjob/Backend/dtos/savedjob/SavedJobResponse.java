package com.mynextjob.Backend.dtos.savedjob;

import com.mynextjob.Backend.dtos.job.JobShortResponse;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SavedJobResponse {
    private Long id;

    // מחזירים אובייקט מקוצר של המשרה (כותרת, חברה, מיקום)
    private JobShortResponse job;

    private LocalDateTime savedAt;
}