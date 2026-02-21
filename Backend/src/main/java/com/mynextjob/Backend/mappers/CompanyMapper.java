package com.mynextjob.Backend.mappers;

import com.mynextjob.Backend.dtos.company.*;
import com.mynextjob.Backend.models.Company;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {

    // המרה ל-DTO רגיל (תצוגה בסיסית)
    CompanyResponse toResponse(Company company);

    // המרה ל-DTO מקוצר (לשימוש בתוך רשימות משרות)
    CompanyShortResponse toShortResponse(Company company);

    // המרה ל-Profile (כולל רשימת המשרות והסטטיסטיקה)
    //  את רשימת המשרות נטען ב-Service כדי לשמור על ביצועים
    CompanyProfileResponse toProfileResponse(Company company);

    // המרה מ-DTO לישות (יצירה)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "jobs", ignore = true)
    Company toEntity(CompanyRequest request);

    // עדכון חברה קיימת - התעלמות משדות ריקים
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "jobs", ignore = true)
    void updateEntityFromDto(CompanyRequest dto, @MappingTarget Company company);
}