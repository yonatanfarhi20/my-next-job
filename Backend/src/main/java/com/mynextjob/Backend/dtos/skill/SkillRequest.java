package com.mynextjob.Backend.dtos.skill;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "בקשה ליצירת כישור (Skill) חדש במערכת")
public class SkillRequest {

    @Schema(
            description = "שם הטכנולוגיה או הכישור",
            example = "Spring Boot",
            minLength = 1,
            maxLength = 30,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "חובה להזין את שם הטכנולוגיה")
    @Size(min = 1, max = 30, message = "שם הטכנולוגיה חייב להיות בין 1 ל-30 תווים")
    private String name;

    @Schema(
            description = "הקטגוריה אליה משתייך הכישור",
            example = "Backend",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "חובה להזין קטגוריה לכישור (למשל: Backend)")
    private String category;
}