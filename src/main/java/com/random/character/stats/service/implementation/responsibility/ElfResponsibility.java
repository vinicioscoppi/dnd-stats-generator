package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;

import java.util.List;

public class ElfResponsibility extends RaceResponsibility {

    public ElfResponsibility(HalflingResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public Race suggestRace(List<Attribute> attributeList) {
        if(appliesToRace(attributeList)) {
            return Race.ELF;
        }
        return nextInChain.suggestRace(attributeList);
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return attributeList.get(INTELLIGENCE).getValue() > 10 &&
               attributeList.get(DEXTERITY).getValue() > 10;
    }
}
