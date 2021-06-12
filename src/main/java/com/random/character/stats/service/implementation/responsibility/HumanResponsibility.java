package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class HumanResponsibility extends RaceResponsibility {

    public HumanResponsibility(OrcResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return attributeList.stream().filter(attr -> attr.getValue() == 10 || attr.getValue() == 11).count() >= 3;
    }

    @Override
    protected Race suggestThis() {
        return Race.HUMAN;
    }
}
