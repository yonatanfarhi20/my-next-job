package com.mynextjob.Backend.dtos.skill;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "פרטי כישור בסיסיים המוחזרים מהמערכת")
public class SkillResponse {

    @Schema(description = "מזהה ייחודי של הכישור", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "שם הטכנולוגיה", example = "React")
    private String name;

    @Schema(description = "הקטגוריה אליה הכישור משתייך", example = "Frontend")
    private String category;
}