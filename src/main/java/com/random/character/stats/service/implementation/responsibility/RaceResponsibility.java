package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;
import com.random.character.stats.service.dto.AttributesDto;

import java.util.List;

public abstract class RaceResponsibility {

    protected RaceResponsibility nextInChain;

    public Race suggestRace(AttributesDto attributesDto) {
        return appliesToRace(attributesDto) ? suggestThis() : nextInChain.suggestRace(attributesDto);
    }

    protected abstract boolean appliesToRace(AttributesDto attributesDto);
    protected abstract Race suggestThis();
}
