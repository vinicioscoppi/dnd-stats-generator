package com.random.character.stats.service.implementation;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.exception.InvalidModifierException;
import com.random.character.stats.model.exception.InvalidValueException;
import com.random.character.stats.service.IAttributeService;
import com.random.character.stats.service.IModifierService;
import com.random.character.stats.service.IRollStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttributeService implements IAttributeService {

    private static final int ATTRIBUTES_COUNT = 6;
    private static final int MINIMUM_VALUE = 3;
    private static final int MAXIMUM_VALUE = 18;
    private static final int MINIMUM_MODIFIER = -3;
    private static final int MAXIMUM_MODIFIER = 4;

    @Autowired
    private IModifierService modifierService;

    public List<Attribute> getAttributes(IRollStrategy rollStrategy) {
        List<Attribute> attributes = new ArrayList<>(ATTRIBUTES_COUNT);
        for (var i = 0; i < ATTRIBUTES_COUNT; i++) {
            attributes.add(getAttribute(rollStrategy));
        }
        return attributes;
    }

    private Attribute getAttribute(IRollStrategy rollStrategy) {
        Integer value = rollStrategy.roll();
        validateValue(value);

        Integer modifier = modifierService.determineModifierFromValue(value);
        validateModifier(modifier);

        return new Attribute(value, modifier);
    }

    private void validateValue(Integer value) {
        if (value == null || value < MINIMUM_VALUE || value > MAXIMUM_VALUE) {
            throw new InvalidValueException(value);
        }
    }

    private void validateModifier(Integer modifier) {
        if (modifier == null || modifier < MINIMUM_MODIFIER || modifier > MAXIMUM_MODIFIER) {
            throw new InvalidModifierException(modifier);
        }
    }

}
