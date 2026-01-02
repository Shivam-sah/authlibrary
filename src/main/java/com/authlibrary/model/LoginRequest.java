package com.authlibrary.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotNull(message = "username can not be Null")
    @NotBlank(message = "username can not be blank")
    private String userName;

    @NotNull(message = "Password can not be Null")
    @NotBlank(message = "Password can not be blank")
    private String password;
}
