package com.mynextjob.Backend.mappers;

import com.mynextjob.Backend.dtos.job.JobRequest;
import com.mynextjob.Backend.dtos.job.JobResponse;
import com.mynextjob.Backend.dtos.job.JobShortResponse;
import com.mynextjob.Backend.models.Job;
import org.mapstruct.*;

// אנו משתמשים ב-uses כדי להשתמש בלוגיקה של מאפרים אחרים במידת הצורך
@Mapper(componentModel = "spring", uses = {CompanyMapper.class, SkillMapper.class})
public interface JobMapper {

    // מיפוי מישות ל-DTO (תצוגה מלאה)
    // חילוץ שם החברה ישירות מהאובייקט המקושר
    @Mapping(target = "companyName", source = "company.name")
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "skillNames", source = "skills") // MapStruct ידע להוציא שמות מה-Skills
    JobResponse toResponse(Job job);

    // מיפוי מישות ל-DTO מקוצר (לרשימות)
    @Mapping(target = "companyName", source = "company.name")
    JobShortResponse toShortResponse(Job job);

    // מיפוי מ-DTO לישות (יצירה)
    // אנחנו מתעלמים מהשדות המורכבים כי נטפל בהם ב-Service (מול ה-DB)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "skills", ignore = true)
    Job toEntity(JobRequest request);

    // עדכון ישות קיימת
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "skills", ignore = true)
    void updateEntityFromDto(JobRequest dto, @MappingTarget Job job);
}