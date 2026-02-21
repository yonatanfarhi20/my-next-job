package com.mynextjob.Backend.mappers;

import com.mynextjob.Backend.dtos.user.requests.*;
import com.mynextjob.Backend.dtos.user.responses.*;

import com.mynextjob.Backend.models.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserResponse toResponse(User user);

    // ביצוע פעולות לפני או אחרי המיפוי (למשל נרמול אימייל)
    @Mapping(target = "email", source = "email", qualifiedByName = "toLowerCase")
    User toEntity(UserRegistrationRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UserUpdateRequest dto, @MappingTarget User user);

    // פונקציית עזר פנימית לנרמול אימייל
    @Named("toLowerCase")
    default String toLowerCase(String email) {
        return email != null ? email.toLowerCase().trim() : null;
    }
}