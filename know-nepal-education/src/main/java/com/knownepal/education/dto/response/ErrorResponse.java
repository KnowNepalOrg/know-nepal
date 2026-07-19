package com.knownepal.education.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private boolean success;
    private int status;
    private String error;
    private String message;
    private Map<String, String> fieldErrors;
    private LocalDateTime timestamp;
    private String path;

    public ErrorResponse(boolean success, int status, String error, String message,
                          Map<String, String> fieldErrors, LocalDateTime timestamp, String path) {
        this.success = success;
        this.status = status;
        this.error = error;
        this.message = message;
        this.fieldErrors = fieldErrors;
        this.timestamp = timestamp;
        this.path = path;
    }
}
