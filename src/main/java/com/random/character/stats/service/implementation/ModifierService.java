package com.random.character.stats.service.implementation;

import com.random.character.stats.model.exception.InvalidValueException;
import com.random.character.stats.service.IModifierService;
import org.springframework.stereotype.Service;

@Service
public class ModifierService implements IModifierService {

    public Integer determineModifierFromValue(Integer value) {
        return applyModifierFormula(value);
    }

    private Integer applyModifierFormula(Integer value) {
        return (value - 10) / 2;
    }
}
