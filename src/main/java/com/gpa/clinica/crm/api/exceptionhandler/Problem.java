package com.gpa.clinica.crm.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problem {

    private final Integer status;
    private final String title;
    private final String detail;
    private final LocalDateTime timestamp;
    private List<FieldError> fieldErrors;

    public Problem(@NonNull Integer status, @NonNull String title, @NonNull String detail) {
        this.status = Objects.requireNonNull(status);
        this.title = Objects.requireNonNull(title);
        this.detail = Objects.requireNonNull(detail);
        this.timestamp = LocalDateTime.now();
    }
}
