package com.authlibrary.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {

    @NotNull(message = "First Name can not be Null")
    @NotBlank(message = "First Name can not be blank")
    private String firstName;

    @NotNull(message = "Last Name can not be Null")
    @NotBlank(message = "Last Name can not be blank")
    private String lastName;

    @NotNull(message = "username can not be Null")
    @NotBlank(message = "username can not be blank")
    private String userName;

    @NotNull(message = "Password can not be Null")
    @NotBlank(message = "Password can not be blank")
    private String password;

    @NotNull(message = "Roles can not be Null")
    @NotBlank(message = "Roles can not be blank")
    private String roles;
}
