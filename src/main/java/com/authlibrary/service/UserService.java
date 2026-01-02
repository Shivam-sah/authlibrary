package com.authlibrary.service;

import com.authlibrary.model.JwtTokenResponse;
import com.authlibrary.model.UserDto;
import com.authlibrary.model.UserRequestDto;
import jakarta.validation.Valid;

public interface UserService {

    UserDto saveUser(@Valid UserRequestDto request);
    JwtTokenResponse generateToken(String userName);
}
