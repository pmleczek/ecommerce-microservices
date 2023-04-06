package dev.pmleczek.authservice.service;

import dev.pmleczek.authservice.dto.AuthRequestBody;
import dev.pmleczek.authservice.dto.RegisterRequestBody;
import dev.pmleczek.authservice.entity.Role;
import dev.pmleczek.authservice.entity.User;
import dev.pmleczek.authservice.exception.AuthenticationFailedException;
import dev.pmleczek.authservice.exception.UserAlreadyExistsException;
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

    public Mono<User> createUser(RegisterRequestBody registerRequestBody) {
        return userRepository.findUserByEmail(registerRequestBody.email())
                .flatMap(user -> Mono.error(new UserAlreadyExistsException("User already exists")))
                .switchIfEmpty(Mono.defer(() -> userRepository.save(new User(
                        registerRequestBody.firstname(),
                        registerRequestBody.lastname(),
                        registerRequestBody.email(),
                        passwordEncoder.encode(registerRequestBody.password()),
                        Role.USER
                ))))
                .cast(User.class);
    }
}
