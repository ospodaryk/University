package com.botscrew.university.exception;

public class ParameterEmptyException extends RuntimeException {
    static String PARAMETER_CANNOT_BE_EMPTY = "Parameter cannot be empty.";

    public ParameterEmptyException() {
        super(PARAMETER_CANNOT_BE_EMPTY);
    }
}