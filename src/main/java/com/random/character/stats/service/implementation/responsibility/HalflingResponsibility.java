package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;

import java.util.List;

public class HalflingResponsibility extends RaceResponsibility {

    public HalflingResponsibility(GnomeResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public Race suggestRace(List<Attribute> attributeList) {
        if(appliesToRace(attributeList)) {
            return Race.HALFLING;
        }
        return nextInChain.suggestRace(attributeList);
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return attributeList.get(DEXTERITY).getValue() > 10 &&
               attributeList.get(STRENGTH).getValue() < 10;
    }
}
