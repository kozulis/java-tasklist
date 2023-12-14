package ru.milovanov.tasklist.service;

import ru.milovanov.tasklist.web.dto.auth.JwtRequest;
import ru.milovanov.tasklist.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtRequest refresh(String refreshToken);

}
