package com.knownepal.education.repository;

import com.knownepal.education.model.AcademicCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicCalendarRepository extends JpaRepository<AcademicCalendar, Long>, JpaSpecificationExecutor<AcademicCalendar> {

    @Query("SELECT a FROM AcademicCalendar a WHERE LOWER(a.eventTitle) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(a.institutionName) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<AcademicCalendar> search(@Param("q") String query);
}
