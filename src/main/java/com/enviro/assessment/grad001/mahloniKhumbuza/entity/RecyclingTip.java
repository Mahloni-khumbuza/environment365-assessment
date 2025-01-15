package com.enviro.assessment.grad001.mahloniKhumbuza.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recycling_tip")
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "wasteCategoryId", nullable = false)
    private Long wasteCategoryId;

    @Column(name = "tip", nullable = false, length = 1000)
    private String tip;
}
