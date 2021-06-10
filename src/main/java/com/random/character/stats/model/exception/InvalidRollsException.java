package com.random.character.stats.model.exception;

import com.random.character.stats.model.Attribute;

import java.util.List;
import java.util.Optional;

public class InvalidRollsException extends IllegalArgumentException {

    private static final int ATTRIBUTES_COUNT = 6;

    public InvalidRollsException(List<Attribute> attributeList) {
        super(String.format("Attribute rolls list size should be %d. It was %s.",
                ATTRIBUTES_COUNT,
                Optional.ofNullable(attributeList)
                        .map(list -> String.valueOf(list.size()))
                        .orElse("null")));
    }
}
