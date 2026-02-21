package com.mynextjob.Backend.dtos.user.requests;

import com.mynextjob.Backend.enums.Role;
import jakarta.validation.constraints.*;

public record UserRegistrationRequest(
        @NotBlank(message = "חובה להזין שם מלא")
        @Size(min = 2, max = 50, message = "השם חייב להיות בין 2 ל-50 תווים")
        String fullName,

        @Email(message = "כתובת האימייל אינה תקינה")
        @NotBlank(message = "חובה להזין אימייל")
        String email,

        @NotBlank(message = "חובה להזין סיסמה")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "הסיסמה חייבת להכיל לפחות אות גדולה, אות קטנה, מספר ותו מיוחד"
        )
        String password,

        @NotNull(message = "חובה לבחור תפקיד (CANDIDATE/EMPLOYER)")
        Role role
) {}