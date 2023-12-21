package ru.milovanov.tasklist.web.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.milovanov.tasklist.domain.user.User;
import ru.milovanov.tasklist.service.AuthService;
import ru.milovanov.tasklist.service.UserService;
import ru.milovanov.tasklist.utils.OpenApiResponses;
import ru.milovanov.tasklist.web.dto.auth.JwtRequest;
import ru.milovanov.tasklist.web.dto.auth.JwtResponse;
import ru.milovanov.tasklist.web.dto.user.UserDto;
import ru.milovanov.tasklist.web.dto.validation.OnCreate;
import ru.milovanov.tasklist.web.mappers.UserMapper;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
@Tag(name = "Auth Controller", description = "Auth API")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    @OpenApiResponses(summary = "Login user", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = JwtResponse.class)))
    public JwtResponse login(@Validated @RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    @OpenApiResponses(summary = "Register user", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = UserDto.class)))
    public UserDto register(@Validated(OnCreate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    @OpenApiResponses(summary = "Refresh token", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = JwtResponse.class)))
    public JwtResponse refresh(@RequestBody @Schema(example = "aERafdcbaerE.GAfcczsde.AEaddgree") String refreshToken) {
        return authService.refresh(refreshToken);
    }

}
