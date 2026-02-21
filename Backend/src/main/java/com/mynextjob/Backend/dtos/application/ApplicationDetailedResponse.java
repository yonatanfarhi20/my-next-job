package com.mynextjob.Backend.dtos.application;

import com.mynextjob.Backend.enums.ApplicationStatus;
import com.mynextjob.Backend.dtos.job.JobShortResponse;
import com.mynextjob.Backend.dtos.user.responses.UserResponse;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ApplicationDetailedResponse {
    private Long id;
    private JobShortResponse job;
    private UserResponse candidate; // מידע מלא על המועמד (שם, אימייל וכו')
    private String coverLetter;     // המכתב המקדים שהמועמד הוסיף
    private ApplicationStatus status;
    private LocalDateTime appliedAt;
    private LocalDateTime updatedAt; // מתי הסטטוס עודכן לאחרונה
}