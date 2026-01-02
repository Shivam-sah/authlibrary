package com.authlibrary.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JwtTokenResponse {

    private String token;
    private String type;
    private String validUntil;
}
