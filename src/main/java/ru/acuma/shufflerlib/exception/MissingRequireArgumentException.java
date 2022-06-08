package ru.acuma.shufflerlib.exception;

import java.util.Arrays;

public class MissingRequireArgumentException extends ApiException {

    public static final String MISSING_ARG = "Missing argument: require %s";

    public MissingRequireArgumentException(String... args) {
        super(String.format(MISSING_ARG, Arrays.toString(args)));
    }
}
