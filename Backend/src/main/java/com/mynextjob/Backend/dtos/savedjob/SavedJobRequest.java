package com.mynextjob.Backend.dtos.savedjob;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SavedJobRequest {
    @NotNull(message = "חובה לציין מזהה משרה")
    private Long jobId;

    @Size(max = 255, message = "הערה אישית מוגבלת ל-255 תווים")
    private String note; // הערה שהמשתמש כותב לעצמו
}