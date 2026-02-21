package com.mynextjob.Backend.dtos.company;

import lombok.*;
import java.util.List;
import com.mynextjob.Backend.dtos.job.JobShortResponse;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CompanyProfileResponse {
    private Long id;
    private String name;
    private String website;
    private String industry;

    // הוספת רשימת משרות מקוצרת כדי להציג בדף החברה
    private List<JobShortResponse> openJobs;

    // נתונים סטטיסטיים (נשלפים בשאילתה נפרדת ב-Service)
    private Long totalActiveJobs;
}