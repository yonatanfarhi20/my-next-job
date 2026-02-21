package com.mynextjob.Backend.dtos.company;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.List;
import com.mynextjob.Backend.dtos.job.JobShortResponse;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(description = "פרופיל חברה מורחב הכולל רשימת משרות ונתונים סטטיסטיים")
public class CompanyProfileResponse {

    @Schema(description = "מזהה ייחודי של החברה", example = "10", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "שם החברה", example = "Microsoft Israel")
    private String name;

    @Schema(description = "כתובת אתר האינטרנט של החברה", example = "https://www.microsoft.com/he-il")
    private String website;

    @Schema(description = "תעשייה/מגזר עסקי", example = "Cloud Computing / Software")
    private String industry;

    @Schema(description = "רשימת משרות פתוחות של החברה בפורמט מקוצר")
    private List<JobShortResponse> openJobs;

    @Schema(
            description = "סה\"כ משרות פעילות שפורסמו על ידי החברה אי פעם במערכת",
            example = "142",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long totalActiveJobs;
}