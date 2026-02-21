package com.mynextjob.Backend.dtos.savedjob;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "תשובה המציינת האם משרה ספציפית שמורה במועדפי המשתמש")
public record SavedJobStatusResponse(

        @Schema(description = "מזהה המשרה שנבדקה", example = "101")
        Long jobId,

        @Schema(description = "האם המשרה שמורה במועדפים של המשתמש הנוכחי", example = "true")
        boolean isSaved
) {}