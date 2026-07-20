package com.knownepal.destinations.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "destination_weather",
        uniqueConstraints = @UniqueConstraint(columnNames = {"destination_id", "weather_season"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinationWeather extends Base {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id", nullable = false)
    private TouristDestination destination;

    @Enumerated(EnumType.STRING)
    @Column(name = "weather_season", nullable = false, length = 20)
    private WeatherSeason weatherSeason;

    @Column(name = "avg_temp_celsius", precision = 5, scale = 1)
    private java.math.BigDecimal avgTempCelsius;

    @Column(name = "min_temp_celsius", precision = 5, scale = 1)
    private java.math.BigDecimal minTempCelsius;

    @Column(name = "max_temp_celsius", precision = 5, scale = 1)
    private java.math.BigDecimal maxTempCelsius;

    @Column(name = "rainfall_mm", precision = 8, scale = 1)
    private java.math.BigDecimal rainfallMm;

    @Column(length = 300)
    private String conditions;

    @Column(name = "is_recommended")
    @Builder.Default
    private Boolean isRecommended = false;
}
