package com.mynextjob.Backend.dtos.skill;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SkillDetailedResponse {
    private Long id;
    private String name;
    private String category;

    // כמה משרות קיימות כרגע שדורשות את הכישור הזה
    private Long activeJobsCount;
}