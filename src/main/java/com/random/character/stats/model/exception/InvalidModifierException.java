package com.random.character.stats.model.exception;

import java.util.Optional;

public class InvalidModifierException extends IllegalArgumentException {

    private static final int MINIMUM_MODIFIER = -3;
    private static final int MAXIMUM_MODIFIER = 4;

    public InvalidModifierException(Integer modifier) {
        super(String.format("Given modifier should be between %d and %d (inclusive). It was %s.",
                MINIMUM_MODIFIER,
                MAXIMUM_MODIFIER,
                Optional.ofNullable(modifier)
                        .map(String::valueOf)
                        .orElse("null")));
    }
}
