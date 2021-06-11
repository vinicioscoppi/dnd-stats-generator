package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;

import java.util.List;

public class UndeterminedRaceResponsibility extends RaceResponsibility {

    public UndeterminedRaceResponsibility() {
        this.nextInChain = null;
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return true;
    }

    @Override
    protected Race suggestThis() {
        return Race.UNDETERMINED;
    }
}
