package com.mynextjob.Backend.dtos.company;

public record CompanyShortResponse(
        Long id,
        String name,
        String industry
) {}