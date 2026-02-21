package com.mynextjob.Backend.dtos.company;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CompanyRequest {

    @NotBlank(message = "חובה להזין את שם החברה")
    @Size(min = 2, max = 100, message = "שם החברה חייב להיות בין 2 ל-100 תווים")
    private String name;

    @URL(message = "כתובת אתר האינטרנט אינה תקינה")
    @NotBlank(message = "חובה להזין כתובת אתר אינטרנט")
    private String website;

    @NotBlank(message = "חובה להזין את תחום הפעילות של החברה")
    private String industry;
}