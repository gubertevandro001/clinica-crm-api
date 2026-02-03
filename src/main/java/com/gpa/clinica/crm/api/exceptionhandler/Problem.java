package com.gpa.clinica.crm.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem {

    private final Integer status;
    private final String title;
    private final String detail;
    private final LocalDateTime timestamp;
    private List<FieldError> fieldErrors;

    public Problem(Integer status, String title, String detail) {
        this.status = Objects.requireNonNull(status);
        this.title = Objects.requireNonNull(title);
        this.detail = Objects.requireNonNull(detail);
        this.timestamp = LocalDateTime.now();
    }

    public Integer getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
