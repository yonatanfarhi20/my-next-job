package com.mynextjob.Backend.dtos.application;

import com.mynextjob.Backend.enums.ApplicationStatus;
import java.time.LocalDateTime;

public record ApplicationHistoryResponse(
        ApplicationStatus status,
        LocalDateTime changedAt
) {}
