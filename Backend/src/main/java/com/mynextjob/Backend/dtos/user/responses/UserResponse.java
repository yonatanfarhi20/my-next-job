package com.mynextjob.Backend.dtos.user.responses;

import com.mynextjob.Backend.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "פרטי המשתמש המוחזרים מהמערכת")
public record UserResponse(

        @Schema(description = "מזהה ייחודי במערכת", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @Schema(description = "שם מלא של המשתמש", example = "ישראל ישראלי")
        String fullName,

        @Schema(description = "כתובת האימייל של המשתמש", example = "israel@example.com")
        String email,

        @Schema(description = "תפקיד המשתמש", example = "CANDIDATE")
        Role role,

        @Schema(description = "זמן יצירת החשבון במערכת", example = "2026-02-22T10:00:00")
        LocalDateTime createdAt
){}