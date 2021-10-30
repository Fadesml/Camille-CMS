package ru.fadesml.camille.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Class<?> clazz, String info) {
        super(NotFoundException.class.getSimpleName() + ", " + clazz.getName() + " - " + info);
    }
}

