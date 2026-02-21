package com.mynextjob.Backend.mappers;

import com.mynextjob.Backend.dtos.application.*;
import com.mynextjob.Backend.models.Application;
import org.mapstruct.*;

// שימוש ב-JobMapper כדי למפות את אובייקט המשרה בתוך ה-Response
@Mapper(componentModel = "spring", uses = {JobMapper.class})
public interface ApplicationMapper {

    // תצוגה רגילה לרשימות
    @Mapping(target = "candidateName", source = "candidate.fullName")
    ApplicationResponse toResponse(Application application);

    // תצוגה מפורטת למעסיק (כולל פרטי מועמד מלאים)
    @Mapping(target = "candidate", source = "candidate") // דורש UserMapper אם רוצים DTO מלא
    ApplicationDetailedResponse toDetailedResponse(Application application);

    // המרה מ-DTO לישות (הגשת מועמדות)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "job", ignore = true)
    @Mapping(target = "candidate", ignore = true)
    @Mapping(target = "status", constant = "PENDING") // סטטוס ראשוני תמיד יהיה PENDING
    @Mapping(target = "appliedAt", expression = "java(java.time.LocalDateTime.now())")
    Application toEntity(ApplicationRequest request);

    // עדכון סטטוס בלבד
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStatus(ApplicationStatusUpdate dto, @MappingTarget Application application);
}