package com.mynextjob.Backend.dtos.user.responses;

import com.mynextjob.Backend.enums.Role;
import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String fullName,
        String email,
        Role role,
        LocalDateTime createdAt
){}