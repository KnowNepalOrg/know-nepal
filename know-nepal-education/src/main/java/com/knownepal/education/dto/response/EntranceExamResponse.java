package com.knownepal.education.dto.response;

import com.knownepal.education.model.ExamFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Entrance exam response")
public record EntranceExamResponse(
        Long id,
        String name,
        String nameNepali,
        String slug,
        String code,
        Long boardId,
        String boardName,
        ExamFormat format,
        String examDate,
        String registrationDeadline,
        String eligibility,
        String syllabus,
        String feeStructure,
        Integer totalSeats,
        Integer durationHours,
        Integer totalMarks,
        Integer passMarks,
        String description,
        String website,
        String imageUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
