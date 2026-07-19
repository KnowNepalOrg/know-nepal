package com.knownepal.education.service.impl;

import com.knownepal.education.dto.response.SearchResponse;
import com.knownepal.education.dto.response.SearchResult;
import com.knownepal.education.repository.*;
import com.knownepal.education.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchServiceImpl implements SearchService {

    private final SchoolRepository schoolRepository;
    private final CollegeRepository collegeRepository;
    private final UniversityRepository universityRepository;
    private final ProgramRepository programRepository;
    private final ExamBoardRepository examBoardRepository;
    private final ScholarshipRepository scholarshipRepository;
    private final EntranceExamRepository entranceExamRepository;
    private final TeacherProfileRepository teacherProfileRepository;
    private final AcademicCalendarRepository academicCalendarRepository;
    private final FeeBreakdownRepository feeBreakdownRepository;
    private final RankingRepository rankingRepository;

    @Override
    public SearchResponse search(String query) {
        if (query == null || query.isBlank()) {
            return new SearchResponse(query,
                    List.of(), List.of(), List.of(), List.of(),
                    List.of(), List.of(), List.of(), List.of(),
                    List.of(), List.of(), List.of(), 0);
        }

        String q = query.trim();

        List<SearchResult> schools = schoolRepository.search(q).stream()
                .map(s -> new SearchResult(
                        s.getId(), s.getName(), s.getNameNepali(), s.getSlug(),
                        "SCHOOL",
                        s.getDistrictName() != null ? s.getDistrictName() : null,
                        s.getType() != null ? s.getType().name() : null))
                .collect(Collectors.toList());

        List<SearchResult> colleges = collegeRepository.search(q).stream()
                .map(c -> new SearchResult(
                        c.getId(), c.getName(), c.getNameNepali(), c.getSlug(),
                        "COLLEGE",
                        c.getDistrictName() != null ? c.getDistrictName() : null,
                        c.getAffiliation()))
                .collect(Collectors.toList());

        List<SearchResult> universities = universityRepository.search(q).stream()
                .map(u -> new SearchResult(
                        u.getId(), u.getName(), u.getNameNepali(), u.getSlug(),
                        "UNIVERSITY",
                        u.getProvinceName() != null ? u.getProvinceName() : null,
                        u.getType() != null ? u.getType().name() : null))
                .collect(Collectors.toList());

        List<SearchResult> programs = programRepository.search(q).stream()
                .map(p -> new SearchResult(
                        p.getId(), p.getName(), p.getNameNepali(), p.getSlug(),
                        "PROGRAM",
                        p.getInstitutionName() != null ? p.getInstitutionName() : null,
                        p.getLevel() != null ? p.getLevel().name() : null))
                .collect(Collectors.toList());

        List<SearchResult> examBoards = examBoardRepository.search(q).stream()
                .map(e -> new SearchResult(
                        e.getId(), e.getName(), e.getNameNepali(), e.getSlug(),
                        "EXAM_BOARD",
                        e.getHeadquarters() != null ? e.getHeadquarters() : null,
                        e.getCategory() != null ? e.getCategory().name() : null))
                .collect(Collectors.toList());

        List<SearchResult> scholarships = scholarshipRepository.search(q).stream()
                .map(s -> new SearchResult(
                        s.getId(), s.getName(), s.getNameNepali(), s.getSlug(),
                        "SCHOLARSHIP",
                        s.getProvider() != null ? s.getProvider() : null,
                        s.getAmount()))
                .collect(Collectors.toList());

        List<SearchResult> entranceExams = entranceExamRepository.search(q).stream()
                .map(e -> new SearchResult(
                        e.getId(), e.getName(), e.getNameNepali(), e.getSlug(),
                        "ENTRANCE_EXAM",
                        e.getBoardName() != null ? e.getBoardName() : null,
                        e.getFormat() != null ? e.getFormat().name() : null))
                .collect(Collectors.toList());

        List<SearchResult> teacherProfiles = teacherProfileRepository.search(q).stream()
                .map(t -> new SearchResult(
                        t.getId(), t.getName(), t.getNameNepali(), t.getSlug(),
                        "TEACHER_PROFILE",
                        t.getInstitutionName() != null ? t.getInstitutionName() : null,
                        t.getSpecialization()))
                .collect(Collectors.toList());

        List<SearchResult> academicCalendars = academicCalendarRepository.search(q).stream()
                .map(a -> new SearchResult(
                        a.getId(), a.getEventTitle(), null, null,
                        "ACADEMIC_CALENDAR",
                        a.getInstitutionName() != null ? a.getInstitutionName() : null,
                        a.getAcademicYear()))
                .collect(Collectors.toList());

        List<SearchResult> feeBreakdowns = feeBreakdownRepository.search(q).stream()
                .map(f -> new SearchResult(
                        f.getId(), f.getProgramName(), null, null,
                        "FEE_BREAKDOWN",
                        f.getInstitutionName() != null ? f.getInstitutionName() : null,
                        f.getComponent() != null ? f.getComponent().name() : null))
                .collect(Collectors.toList());

        List<SearchResult> rankings = rankingRepository.search(q).stream()
                .map(r -> new SearchResult(
                        r.getId(), r.getInstitutionName(), null, null,
                        "RANKING",
                        r.getSource() != null ? r.getSource().name() : null,
                        r.getCategory()))
                .collect(Collectors.toList());

        int totalResults = schools.size() + colleges.size() + universities.size()
                + programs.size() + examBoards.size() + scholarships.size()
                + entranceExams.size() + teacherProfiles.size() + academicCalendars.size()
                + feeBreakdowns.size() + rankings.size();

        return new SearchResponse(query,
                schools, colleges, universities, programs,
                examBoards, scholarships, entranceExams, teacherProfiles,
                academicCalendars, feeBreakdowns, rankings, totalResults);
    }
}
