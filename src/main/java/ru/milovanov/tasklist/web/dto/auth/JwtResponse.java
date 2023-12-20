package ru.milovanov.tasklist.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Response after login")
public class JwtResponse {
    @Schema(description = "id", example = "1")
    private Long id;

    @Schema(description = "email", example = "johndoe@gmail.com")
    private String username;

    @Schema(description = "JWT access token", example = "rgefdgzdfgre.adasgargan.acbzcxzha")
    private String accessToken;

    @Schema(description = "JWT refresh token", example = "aERafdcbaerE.GAfcczsde.AEaddgree")
    private String refreshToken;

}
