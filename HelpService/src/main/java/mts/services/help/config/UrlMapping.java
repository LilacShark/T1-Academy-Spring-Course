package mts.services.help.config;

import mts.services.help.model.HttpMethod;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UrlMapping {

    HttpMethod method();
    String path();
}
