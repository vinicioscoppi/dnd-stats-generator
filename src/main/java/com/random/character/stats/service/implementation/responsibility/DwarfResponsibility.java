package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;

import java.util.List;

public class DwarfResponsibility extends RaceResponsibility {

    public DwarfResponsibility(ElfResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public Race suggestRace(List<Attribute> attributeList) {
        if(appliesToRace(attributeList)) {
            return Race.DWARF;
        }
        return nextInChain.suggestRace(attributeList);
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return attributeList.get(CONSTITUTION).getValue() > 10 &&
               attributeList.get(CHARISMA).getValue() < 10;
    }
}
