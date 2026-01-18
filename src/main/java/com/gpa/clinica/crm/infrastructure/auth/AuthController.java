package com.gpa.clinica.crm.infrastructure.auth;

import com.gpa.clinica.crm.infrastructure.auth.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements AuthControllerOpenAPI {

    private final AuthService authService;

    public LoginResponse login(LoginRequest loginRequest) {
        return LoginResponse.aPartirDe(authService.login(loginRequest.login(),  loginRequest.senha()));
    }

    public RefreshResponse refresh(RefreshRequest refreshRequest) {
        return RefreshResponse.aPartirDe(authService.refresh(refreshRequest.refreshToken()));
    }

    public void register(RegisterRequest registerRequest) {
        authService.register(registerRequest);
    }
}
