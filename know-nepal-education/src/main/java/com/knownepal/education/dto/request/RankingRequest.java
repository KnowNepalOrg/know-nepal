package com.knownepal.education.dto.request;

import com.knownepal.education.model.RankingSource;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RankingRequest {

    @NotBlank(message = "Institution type is required")
    @Size(max = 30)
    @Schema(example = "UNIVERSITY")
    private String institutionType;

    @Schema(example = "1")
    private Long institutionId;

    @Size(max = 200)
    @Schema(example = "Tribhuvan University")
    private String institutionName;

    private RankingSource source;

    @Schema(example = "1")
    private Integer rankPosition;

    @Schema(example = "85.5")
    private Double score;

    @Size(max = 100)
    @Schema(example = "Engineering")
    private String category;

    @NotBlank(message = "Year is required")
    @Size(max = 10)
    @Schema(example = "2082")
    private String year;

    @Size(max = 2000)
    @Schema(example = "Ranked first in engineering category")
    private String description;

    @Schema(example = "https://ranking.example.com/tu")
    private String website;
}
