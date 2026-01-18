package com.gpa.clinica.crm.api.exceptionhandler;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gpa.clinica.crm.domain.exception.EntidadeNaoEncontradaException;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.DateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Hidden
@RestControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    public APIExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private static final String MSG_ERRO_GENERICA_USUARIO_FINAL = "Ocorreu um erro interno inesperado no sistema. Tente" +
            " novamente e se o problema persistir, entre em contato com o administrador do sistema.";

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> internalServerError(WebRequest request, Exception exception) {
        final var title = "Erro interno no servidor";
        final var problem = new Problem(HttpStatus.INTERNAL_SERVER_ERROR.value(), title, MSG_ERRO_GENERICA_USUARIO_FINAL);

        return handleExceptionInternal(exception, problem, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleEntidadeNaoEncontradaException(WebRequest request,
                                                                       EntidadeNaoEncontradaException exception) {
        final var title = "Entidade não encontrada";
        final var problem = new Problem(HttpStatus.NOT_FOUND.value(), title, exception.getMessage());
        return handleExceptionInternal(exception, problem, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({AuthenticationException.class, UsernameNotFoundException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex, WebRequest request) {
        final var title = "Credenciais inválidas";
        final var problem = new Problem(HttpStatus.UNAUTHORIZED.value(), title,
                "As credenciais de acesso fornecidas estão inválidas, " +
                        "revise as informações e realize novamente o login!");

        return handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler({JWTVerificationException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<Object> handleJWTVerificationException(JWTVerificationException ex, WebRequest request) {
        final var title = "Token inválido";
        final var problem = new Problem(HttpStatus.UNAUTHORIZED.value(), title, ex.getMessage());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                            HttpHeaders headers, HttpStatusCode status,
                                                                            WebRequest request) {
        return handleValidationInternal(ex, ex.getBindingResult(), headers, status, request);
    }

    private ResponseEntity<Object> handleValidationInternal(Exception ex, BindingResult bindingResult, HttpHeaders headers,
                                                            HttpStatusCode status, WebRequest request) {

        final var title = "Dados Inválidos!";
        String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";

        List<com.gpa.clinica.crm.api.exceptionhandler.FieldError> problemObjects = bindingResult.getAllErrors().stream()
                .map(objectError -> {
                    String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());

                    String name = objectError.getObjectName();

                    if (objectError instanceof org.springframework.validation.FieldError) {
                        name = ((FieldError) objectError).getField();
                    }

                    return new com.gpa.clinica.crm.api.exceptionhandler.FieldError(name, message);

                })
                .collect(Collectors.toList());

        Problem problem = new Problem(status.value(), title, detail);
        problem.setFieldErrors(problemObjects);

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body,
                                                                       HttpHeaders headers, HttpStatusCode statusCode,
                                                                       WebRequest request) {

        if (body == null) {
            String title = HttpStatus.valueOf(statusCode.value()).getReasonPhrase();
            body = new Problem(statusCode.value(), title, MSG_ERRO_GENERICA_USUARIO_FINAL);
        } else if (body instanceof String str) {
            String title = HttpStatus.valueOf(statusCode.value()).getReasonPhrase();
            body = new Problem(statusCode.value(), title, str);
        }

        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }
}
