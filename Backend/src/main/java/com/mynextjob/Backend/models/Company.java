package com.mynextjob.Backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "companies")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "חובה להזין את שם החברה")
    @Size(min = 2, max = 100, message = "שם החברה חייב להיות בין 2 ל-100 תווים")
    private String name;

    @URL(message = "כתובת אתר האינטרנט אינה תקינה")
    private String website;
    @NotBlank(message = "חובה להזין את תחום הפעילות של החברה (למשל: הייטק)")
    private String industry;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); updatedAt = LocalDateTime.now(); }

    @PreUpdate
    protected void onUpdate() { updatedAt = LocalDateTime.now(); }

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Job> jobs = new ArrayList<>();
}