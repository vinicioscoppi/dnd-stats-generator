package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;

import java.util.List;

public class UndeterminedRaceResponsibility extends RaceResponsibility {

    public UndeterminedRaceResponsibility() {
        this.nextInChain = null;
    }

    @Override
    public Race suggestRace(List<Attribute> attributeList) {
        if(appliesToRace(attributeList)) {
            return Race.UNDETERMINED;
        }
        return nextInChain.suggestRace(attributeList);
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return true;
    }
}
