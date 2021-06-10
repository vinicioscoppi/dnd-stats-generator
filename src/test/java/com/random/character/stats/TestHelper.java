package com.random.character.stats;

import com.random.character.stats.model.Attribute;

import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public static final int ATTRIBUTES_COUNT = 6;
    public static final int TEST_MODIFIER = 2;
    public static final int TEST_VALUE = 15;

    public static List<Attribute> getTestAttributeList() {
        List<Attribute> attributes = new ArrayList<>(ATTRIBUTES_COUNT);
        for (var i = 0; i < ATTRIBUTES_COUNT; i++) {
            attributes.add(getTestAttribute());
        }
        return attributes;
    }

    public static Attribute getTestAttribute() {
        return new Attribute(TEST_VALUE, TEST_MODIFIER);
    }
}
