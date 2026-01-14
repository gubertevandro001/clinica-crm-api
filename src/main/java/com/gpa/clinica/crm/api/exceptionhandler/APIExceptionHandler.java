package com.gpa.clinica.crm.api.exceptionhandler;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gpa.clinica.crm.domain.exception.EntidadeNaoEncontradaException;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Hidden
@RestControllerAdvice
@AllArgsConstructor
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String MSG_ERRO_GENERICA_USUARIO_FINAL = "Ocorreu um erro interno inesperado no sistema. Tente" +
            "novamente e se o problema persistir, entre em contato com o administrador do sistema.";


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
