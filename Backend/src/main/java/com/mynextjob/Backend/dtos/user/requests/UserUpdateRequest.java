package com.mynextjob.Backend.dtos.user.requests;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
public record UserUpdateRequest(

        @Size(min = 2, max = 50, message = "השם חייב להיות בין 2 ל-50 תווים")
        String fullName,
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "הסיסמה החדשה חייבת להכיל לפחות אות גדולה, אות קטנה, מספר ותו מיוחד"
        )
        String password
) {}