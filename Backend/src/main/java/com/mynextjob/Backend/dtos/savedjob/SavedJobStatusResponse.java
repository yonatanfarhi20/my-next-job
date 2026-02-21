package com.mynextjob.Backend.dtos.savedjob;

public record SavedJobStatusResponse(
        Long jobId,
        boolean isSaved
) {}