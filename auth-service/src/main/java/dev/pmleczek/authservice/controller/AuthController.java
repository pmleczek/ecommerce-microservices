package dev.pmleczek.authservice.controller;

import dev.pmleczek.authservice.dto.AuthRequestBody;
import dev.pmleczek.authservice.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth")
    public Mono<String> authenticate(@RequestBody AuthRequestBody requestBody) {
        return authService.authenticate(requestBody);
    }
}
