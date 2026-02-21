package com.mynextjob.Backend.dtos.skill;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SkillRequest {

    @NotBlank(message = "חובה להזין את שם הטכנולוגיה")
    @Size(min = 1, max = 30, message = "שם הטכנולוגיה חייב להיות בין 1 ל-30 תווים")
    private String name;

    @NotBlank(message = "חובה להזין קטגוריה לכישור (למשל: Backend)")
    private String category;
}