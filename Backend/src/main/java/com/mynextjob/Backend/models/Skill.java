package com.mynextjob.Backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity @Table(name = "skills")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Skill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "חובה להזין את שם הטכנולוגיה (למשל: Java)")
    @Size(min = 1, max = 30, message = "שם הטכנולוגיה חייב להיות בין 1 ל-30 תווים")
    private String name;

    @NotBlank(message = "חובה להזין קטגוריה לכישור (למשל: Backend)")
    private String category;

    @ManyToMany(mappedBy = "skills")
    private Set<Job> jobs = new HashSet<>();
}