package ru.fadesml.camille.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends CamilleException {
    public NotFoundException(Class<?> clazz, Map<String, Object> metadata) {
        super(NotFoundException.class.getSimpleName() + ", " + clazz.getName(), metadata);
    }
}

