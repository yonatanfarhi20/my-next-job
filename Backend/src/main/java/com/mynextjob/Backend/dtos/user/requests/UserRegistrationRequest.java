package com.mynextjob.Backend.dtos.user.requests;

import com.mynextjob.Backend.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "בקשה לרישום משתמש חדש במערכת")
public record UserRegistrationRequest(

        @Schema(
                description = "שם מלא של המשתמש",
                example = "ישראל ישראלי",
                minLength = 2,
                maxLength = 50,
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(message = "חובה להזין שם מלא")
        @Size(min = 2, max = 50, message = "השם חייב להיות בין 2 ל-50 תווים")
        String fullName,

        @Schema(
                description = "כתובת אימייל ייחודית שתשמש לכניסה",
                example = "israel.i@example.com",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @Email(message = "כתובת האימייל אינה תקינה")
        @NotBlank(message = "חובה להזין אימייל")
        String email,

        @Schema(
                description = "סיסמה מאובטחת: לפחות 8 תווים, כולל אות גדולה, קטנה, מספר ותו מיוחד",
                example = "SecureP@ss123",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(message = "חובה להזין סיסמה")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "הסיסמה חייבת להכיל לפחות אות גדולה, אות קטנה, מספר ותו מיוחד"
        )
        String password,

        @Schema(
                description = "תפקיד המשתמש במערכת",
                example = "CANDIDATE",
                allowableValues = {"CANDIDATE", "EMPLOYER"},
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotNull(message = "חובה לבחור תפקיד (CANDIDATE/EMPLOYER)")
        Role role
) {}