package com.mynextjob.Backend.dtos.skill;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "אובייקט קל לחיפוש ושליפת כישורים (Lookup)")
public record SkillLookupDTO(

        @Schema(description = "מזהה הכישור", example = "5")
        Long id,

        @Schema(description = "שם הכישור", example = "Python")
        String name
) {}