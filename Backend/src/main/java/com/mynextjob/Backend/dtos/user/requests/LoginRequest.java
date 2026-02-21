package com.mynextjob.Backend.dtos.user.requests;

import jakarta.validation.constraints.*;

public record LoginRequest(
        @Email(message = "כתובת האימייל אינה תקינה")
        @NotBlank(message = "חובה להזין אימייל")
        String email,

        @NotBlank(message = "חובה להזין סיסמה")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "הסיסמה חייבת להכיל לפחות אות גדולה, אות קטנה, מספר ותו מיוחד"
        )
        String password
) {}