package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class HalfElfResponsibility extends RaceResponsibility {

    public HalfElfResponsibility(UndeterminedRaceResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return attributeList.get(CHARISMA).getValue() > 10 &&
               attributeList.get(WISDOM).getValue() > 10;
    }

    @Override
    protected Race suggestThis() {
        return Race.HALF_ELF;
    }
}
