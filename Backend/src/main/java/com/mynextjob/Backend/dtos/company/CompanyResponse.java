package com.mynextjob.Backend.dtos.company;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CompanyResponse {
    private Long id;
    private String name;
    private String website;
    private String industry;
    private LocalDateTime createdAt;
}