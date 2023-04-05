package dev.pmleczek.authservice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dev.pmleczek.authservice.config.JWTProperties;
import dev.pmleczek.authservice.entity.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JWTService {
    private final JWTProperties jwtProperties;

    public JWTService(JWTProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public String getAccessToken(User userDetails) {
        return JWT.create()
                .withSubject(userDetails.getId().toString())
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plus(20, ChronoUnit.MINUTES))
                .withIssuer(jwtProperties.getIssuer())
                .withClaim("role", userDetails.getRole().toString())
                .sign(Algorithm.RSA256(
                        jwtProperties.getPublicKey(),
                        jwtProperties.getPrivateKey()
                ));
    }

    public String getRefreshToken(User userDetails) {
        return null;
    }
}
