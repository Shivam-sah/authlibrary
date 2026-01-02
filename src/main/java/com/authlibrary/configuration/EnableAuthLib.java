package com.authlibrary.configuration;

import org.springframework.context.annotation.Import;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({AuthLibConfiguration.class})
public @interface EnableAuthLib {
}
