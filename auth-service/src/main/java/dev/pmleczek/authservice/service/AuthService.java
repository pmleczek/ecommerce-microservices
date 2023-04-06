package dev.pmleczek.authservice.service;

import dev.pmleczek.authservice.dto.AuthRequestBody;
import dev.pmleczek.authservice.exception.AuthenticationFailedException;
import dev.pmleczek.authservice.exception.UserNotFoundException;
import dev.pmleczek.authservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JWTService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public Mono<String> authenticate(AuthRequestBody authRequestBody) {
        return userRepository.findUserByEmail(authRequestBody.email())
                .flatMap(user -> {
                    if (passwordEncoder.matches(authRequestBody.password(), user.getPassword())) {
                        return Mono.just(jwtService.getAccessToken(user));
                    }
                    return Mono.error(new AuthenticationFailedException("User authentication failed"));
                })
                .switchIfEmpty(Mono.error(new UserNotFoundException("User not found")));
    }
}
