package com.authlibrary.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({SecurityConfig.class, SwaggerConfiguration.class})
public class AuthLibConfiguration {
}
