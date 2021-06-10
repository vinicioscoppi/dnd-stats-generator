package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;

import java.util.List;

public class OrcResponsibility extends RaceResponsibility {

    public OrcResponsibility(DwarfResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public Race suggestRace(List<Attribute> attributeList) {
        if (appliesToRace(attributeList)) {
            return Race.ORC;
        }
        return nextInChain.suggestRace(attributeList);
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return attributeList.get(STRENGTH).getValue() > 10 &&
               attributeList.get(INTELLIGENCE).getValue() < 10;
    }
}
