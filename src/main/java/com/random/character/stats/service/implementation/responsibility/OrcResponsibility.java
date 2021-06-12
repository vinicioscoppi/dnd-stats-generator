package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class OrcResponsibility extends RaceResponsibility {

    public OrcResponsibility(DwarfResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return attributeList.get(STRENGTH).getValue() > 10 &&
               attributeList.get(INTELLIGENCE).getValue() < 10;
    }

    @Override
    protected Race suggestThis() {
        return Race.ORC;
    }
}
