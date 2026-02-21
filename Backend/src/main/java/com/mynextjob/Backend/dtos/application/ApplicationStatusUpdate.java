package com.mynextjob.Backend.dtos.application;

import com.mynextjob.Backend.enums.ApplicationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ApplicationStatusUpdate {

    @NotNull(message = "חובה לציין סטטוס חדש")
    private ApplicationStatus status;
}