package com.mynextjob.Backend.dtos.skill;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "פרטי כישור מורחבים הכוללים סטטיסטיקת שימוש")
public class SkillDetailedResponse {

    @Schema(description = "מזהה ייחודי של הכישור", example = "101", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "שם הכישור (למשל: Java, React, SQL)", example = "Java")
    private String name;

    @Schema(description = "קטגוריית הכישור", example = "Backend Development")
    private String category;

    @Schema(
            description = "מספר המשרות הפעילות במערכת הדורשות כרגע את הכישור הזה",
            example = "25",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long activeJobsCount;
}