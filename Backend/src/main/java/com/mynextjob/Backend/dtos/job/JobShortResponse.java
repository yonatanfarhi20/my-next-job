package com.mynextjob.Backend.dtos.job;

public record JobShortResponse(
        Long id,
        String title,
        String companyName,
        String location,
        Double minSalary,
        Double maxSalary,
        String category
        // שים לב: אין כאן תיאור משרה ואין רשימת כישורים מלאה
) {}