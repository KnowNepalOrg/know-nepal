package com.knownepal.culture.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "languages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Language extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "language_family", nullable = false, length = 30)
    private LanguageFamily languageFamily;

    @Enumerated(EnumType.STRING)
    @Column(name = "language_status", nullable = false, length = 35)
    private LanguageStatus languageStatus;

    @Column(name = "speakers_count")
    private Long speakersCount;

    @Column(length = 100)
    private String script;

    @Column(name = "writing_system", length = 100)
    private String writingSystem;

    @Column(columnDefinition = "TEXT")
    private String dialects;

    @Column(name = "is_official")
    private Boolean isOfficial;

    @Column(name = "is_lingua_franca")
    private Boolean isLinguaFranca;

    @Enumerated(EnumType.STRING)
    @Column(name = "region_type", length = 20)
    private RegionType regionType;

    @Column(length = 100)
    private String province;

    @Column(name = "origin_history", columnDefinition = "TEXT")
    private String originHistory;

    @Column(name = "cultural_significance", columnDefinition = "TEXT")
    private String culturalSignificance;

    @Column(name = "endangered_details", columnDefinition = "TEXT")
    private String endangeredDetails;

    @Column(name = "preservation_efforts", columnDefinition = "TEXT")
    private String preservationEfforts;
}
