package com.example.cafeshop.web.dto.user;

import com.example.cafeshop.web.dto.validation.OnCreate;
import com.example.cafeshop.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Schema(description = "User DTO")
public class UserDto {

    @Schema(description = "User ID", example = "1")
    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private Long id;

    @Schema(description = "User name", example = "Zhamso Gungaev")
    @NotNull(message = "Name must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String name;

    @Schema(description = "User login", example = "pussydestroyer@mail.com")
    @NotNull(message = "Login must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Login length must be smaller than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String login;

    @Schema(description = "User crypted password", example = "$2a$10$hyeEw8st5Qhi9LcZchuEXO5CRaDasdv0yB.zBKfeOYowuCWSyWFaMNXO")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null", groups = {OnCreate.class, OnUpdate.class})
    private String password;

    @Schema(description = "User crypted password", example = "$2a$10$hyeEw8st5Qhi9LcZchuEXO5CRaDasdv0yB.zBKfeOYowuCWSyWFaMNXO")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must be not null", groups = {OnCreate.class})
    private String passwordConfirmation;

}
