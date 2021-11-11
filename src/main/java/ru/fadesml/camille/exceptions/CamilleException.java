package ru.fadesml.camille.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CamilleException extends RuntimeException {
    private final Map<String, Object> metadata;

    public CamilleException(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public CamilleException(String message, Map<String, Object> metadata) {
        super(message);
        this.metadata = metadata;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }
}
