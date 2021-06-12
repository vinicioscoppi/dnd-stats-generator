package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class DwarfResponsibility extends RaceResponsibility {

    public DwarfResponsibility(ElfResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    protected boolean appliesToRace(List<Attribute> attributeList) {
        return attributeList.get(CONSTITUTION).getValue() > 10 &&
               attributeList.get(CHARISMA).getValue() < 10;
    }

    @Override
    protected Race suggestThis() {
        return Race.DWARF;
    }
}
