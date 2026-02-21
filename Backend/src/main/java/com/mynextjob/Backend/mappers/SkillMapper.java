package com.mynextjob.Backend.mappers;

import com.mynextjob.Backend.dtos.skill.*;
import com.mynextjob.Backend.models.Skill;
import org.mapstruct.*;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SkillMapper {

    // המרה ל-DTO בסיסי (למשל עבור רשימות בטפסים)
    SkillResponse toResponse(Skill skill);

    // המרה ל-DTO מפורט (כולל מונה השימושים)
    @Mapping(target = "activeJobsCount", expression = "java(skill.getJobs() != null ? (long) skill.getJobs().size() : 0L)")
    SkillDetailedResponse toDetailedResponse(Skill skill);

    // המרה מ-DTO לישות (יצירה)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "jobs", ignore = true)
    Skill toEntity(SkillRequest request);

    // פונקציית עזר להמרת רשימת אובייקטים לשמות (עבור ה-JobResponse)
    default Set<String> mapSkillsToNames(Set<Skill> skills) {
        if (skills == null) return null;
        return skills.stream()
                .map(Skill::getName)
                .collect(Collectors.toSet());
    }
}