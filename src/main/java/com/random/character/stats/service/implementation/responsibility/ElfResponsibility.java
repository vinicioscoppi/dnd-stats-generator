package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class ElfResponsibility extends RaceResponsibility {

    public ElfResponsibility(HalflingResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return attributeList.get(INTELLIGENCE).getValue() >= 12 &&
               attributeList.get(DEXTERITY).getValue() >= 12;
    }

    @Override
    protected Race suggestThis() {
        return Race.ELF;
    }
}
