package com.knownepal.education.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "academic_calendars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcademicCalendar extends Base {

    @Column(name = "institution_type", nullable = false, length = 30)
    private String institutionType;

    @Column(name = "institution_id", nullable = false)
    private Long institutionId;

    @Column(name = "institution_name", length = 200)
    private String institutionName;

    @Column(name = "event_title", nullable = false, length = 200)
    private String eventTitle;

    @Column(name = "event_description", columnDefinition = "TEXT")
    private String eventDescription;

    @Column(name = "start_date", nullable = false, length = 50)
    private String startDate;

    @Column(name = "end_date", length = 50)
    private String endDate;

    @Column(name = "academic_year", length = 20)
    private String academicYear;

    @Column(name = "semester", length = 50)
    private String semester;

    @Column(name = "image_url", length = 255)
    private String imageUrl;
}
