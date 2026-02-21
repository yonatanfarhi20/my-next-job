package com.mynextjob.Backend.dtos.application;

import com.mynextjob.Backend.enums.ApplicationStatus;
import com.mynextjob.Backend.dtos.job.JobShortResponse;
import com.mynextjob.Backend.dtos.user.responses.UserResponse; // או DTO קטן יותר של מועמד
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ApplicationResponse {
    private Long id;

    // פרטי המשרה (שם חברה, כותרת משרה וכו')
    private JobShortResponse job;

    // פרטי המועמד (שם ואימייל)
    private String candidateName;
    private ApplicationStatus status;
    private LocalDateTime appliedAt;
}