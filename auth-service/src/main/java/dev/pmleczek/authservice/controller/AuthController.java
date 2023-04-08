package dev.pmleczek.authservice.controller;

import dev.pmleczek.authservice.dto.AuthRequestBody;
import dev.pmleczek.authservice.dto.RegisterRequestBody;
import dev.pmleczek.authservice.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public Mono<String> authenticate(@RequestBody AuthRequestBody requestBody) {
        return authService.authenticate(requestBody);
    }

    @PostMapping("/register")
    public Mono<Void> register(@RequestBody RegisterRequestBody requestBody) {
        return authService.createUser(requestBody)
                .flatMap(user -> Mono.empty());
    }
}
