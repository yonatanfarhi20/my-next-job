package com.mynextjob.Backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name = "saved_jobs",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "job_id"})})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SavedJob {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "שמירה חייבת להיות משויכת למשתמש")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    @NotNull(message = "שמירה חייבת להיות משויכת למשרה")
    private Job job;

    private LocalDateTime savedAt;

    @PrePersist
    protected void onCreate() { savedAt = LocalDateTime.now(); }
}