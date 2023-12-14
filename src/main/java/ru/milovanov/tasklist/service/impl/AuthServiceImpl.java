package ru.milovanov.tasklist.service.impl;

import org.springframework.stereotype.Service;
import ru.milovanov.tasklist.service.AuthService;
import ru.milovanov.tasklist.web.dto.auth.JwtRequest;
import ru.milovanov.tasklist.web.dto.auth.JwtResponse;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtRequest refresh(String refreshToken) {
        return null;
    }

}
