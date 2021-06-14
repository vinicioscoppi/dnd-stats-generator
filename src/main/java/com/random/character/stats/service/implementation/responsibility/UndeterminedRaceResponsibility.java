package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Race;
import com.random.character.stats.service.dto.AttributesDto;

public class UndeterminedRaceResponsibility extends RaceResponsibility {

    public UndeterminedRaceResponsibility() {
        this.nextInChain = null;
    }

    @Override
    protected boolean appliesToRace(AttributesDto attributesDto) {
        return true;
    }

    @Override
    protected Race suggestThis() {
        return Race.UNDETERMINED;
    }
}
