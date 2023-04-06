package dev.pmleczek.authservice.dto;

public record RegisterRequestBody(String firstname, String lastname, String email, String password) {
}
