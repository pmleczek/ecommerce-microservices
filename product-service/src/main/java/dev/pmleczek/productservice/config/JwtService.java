package dev.pmleczek.productservice.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private final JWTVerifier verifier;

    public JwtService(JwtProperties jwtProperties) {
        this.verifier = JWT.require(Algorithm.RSA256(jwtProperties.getPublicKey(), null))
                .withIssuer(jwtProperties.getIssuer())
                .build();
    }

    public String getSubject(String token) {
        return verifier.verify(token).getSubject();
    }

    public String getRole(String token) {
        return verifier.verify(token).getClaim("role").asString();
    }
}
