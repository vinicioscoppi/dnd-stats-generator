package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;

import java.util.List;

public class HumanResponsibility extends RaceResponsibility {

    public HumanResponsibility(OrcResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public Race suggestRace(List<Attribute> attributeList) {
        if (appliesToRace(attributeList)) {
            return Race.HUMAN;
        }
        return nextInChain.suggestRace(attributeList);
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return attributeList.stream().filter(attr -> attr.getValue() >= 10).count() >= 3;
    }
}
