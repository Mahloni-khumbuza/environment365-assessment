package com.enviro.assessment.grad001.mahloniKhumbuza.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "disposal_guideline")
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "wasteCategoryId", nullable = false)
    private Long wasteCategoryId;

    @Column(name = "guideline", nullable = false, length = 1000)
    private String guideline;

    @Column(name = "hazardous", nullable = false)
    private boolean hazardous;
}
