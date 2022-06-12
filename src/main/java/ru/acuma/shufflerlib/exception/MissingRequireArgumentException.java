package ru.acuma.shufflerlib.exception;

import java.util.Arrays;

public class MissingRequireArgumentException extends ApiException {

    public static final String MISSING_ARG = "Missing argument: require %s";
    public static final String MISSING_ONE_OF_ARG = "Missing argument: require one of %s";

    public MissingRequireArgumentException(String message, String... args) {
        super(String.format(message, Arrays.toString(args)));
    }
}
