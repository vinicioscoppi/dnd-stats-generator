package com.random.character.stats;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.service.dto.AttributesDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestHelper {

    public static final int ATTRIBUTES_COUNT = 6;
    public static final int ANY_MODIFIER = 0;
    public static final int ANY_VALUE = 0;
    public static final int ANY_VALID_VALUE = 10;

    public static AttributesDto getTestAttributesDto() {
        return new AttributesDto(getTestAttributeList());
    }

    public static List<Attribute> getTestAttributeList() {
        return Stream.generate(TestHelper::getTestAttribute).limit(ATTRIBUTES_COUNT).collect(Collectors.toList());
    }

    public static Attribute getTestAttribute() {
        return new Attribute(ANY_VALID_VALUE, ANY_MODIFIER);
    }
}
