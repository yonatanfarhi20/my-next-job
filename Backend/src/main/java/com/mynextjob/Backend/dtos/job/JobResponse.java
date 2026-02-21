package com.mynextjob.Backend.dtos.job;

import java.time.LocalDateTime;
import java.util.Set;

public record JobResponse(
        Long id,
        String title,
        Long companyId,
        String companyName,   // שליפת השם מה-Entity
        String location,
        String description,
        Double minSalary,
        Double maxSalary,
        String category,
        Set<String> skillNames, // שמות הכישורים במקום ה-IDs
        LocalDateTime updatedAt
) {}