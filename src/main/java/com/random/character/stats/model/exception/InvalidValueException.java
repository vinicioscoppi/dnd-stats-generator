package com.random.character.stats.model.exception;

import java.util.Optional;

public class InvalidValueException extends IllegalArgumentException {

    private static final int MINIMUM_VALUE = 3;
    private static final int MAXIMUM_VALUE = 18;

    public InvalidValueException(Integer value) {
        super(String.format("Given value should be between %d and %d (inclusive). It was %s.",
                MINIMUM_VALUE,
                MAXIMUM_VALUE,
                Optional.ofNullable(value)
                        .map(String::valueOf)
                        .orElse("null")));
    }
}
