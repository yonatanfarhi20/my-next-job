package com.mynextjob.Backend.models;

import com.mynextjob.Backend.enums.ApplicationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name = "applications",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "job_id"})})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @NotNull(message = "חובה לתעד את זמן הגשת המועמדות")
    private LocalDateTime appliedAt;

    @NotNull(message = "חובה להגדיר סטטוס לפנייה")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @PrePersist
    protected void onCreate() { appliedAt = LocalDateTime.now(); }
}