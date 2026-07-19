package com.knownepal.education.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rankings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ranking extends Base {

    @Column(name = "institution_type", nullable = false, length = 30)
    private String institutionType;

    @Column(name = "institution_id", nullable = false)
    private Long institutionId;

    @Column(name = "institution_name", length = 200)
    private String institutionName;

    @Enumerated(EnumType.STRING)
    @Column(name = "source", nullable = false, length = 30)
    private RankingSource source;

    @Column(name = "rank_position", nullable = false)
    private Integer rankPosition;

    @Column(name = "score")
    private Double score;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "year", nullable = false, length = 10)
    private String year;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "website", length = 255)
    private String website;
}
