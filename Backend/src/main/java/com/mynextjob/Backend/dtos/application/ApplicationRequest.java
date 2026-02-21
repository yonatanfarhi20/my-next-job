package com.mynextjob.Backend.dtos.application;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ApplicationRequest {

    @NotNull(message = "חובה לציין מזהה משרה")
    private Long jobId;

    // ניתן להוסיף שדה אופציונלי להערה מהמועמד (Cover Letter)
    private String coverLetter;
}