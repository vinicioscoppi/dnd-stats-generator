package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;

import java.util.List;

public class HalfElfResponsibility extends RaceResponsibility {

    public HalfElfResponsibility(UndeterminedRaceResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public Race suggestRace(List<Attribute> attributeList) {
        if(appliesToRace(attributeList)) {
            return Race.HALF_ELF;
        }
        return nextInChain.suggestRace(attributeList);
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return attributeList.get(CHARISMA).getValue() > 10 &&
               attributeList.get(WISDOM).getValue() > 10;
    }
}
