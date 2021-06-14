package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Race;
import com.random.character.stats.service.dto.AttributesDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DwarfResponsibility extends RaceResponsibility {

    public DwarfResponsibility(ElfResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    protected boolean appliesToRace(AttributesDto attributesDto) {
        return attributesDto.getConstitution().getValue() > 10 &&
               attributesDto.getCharisma().getValue() < 10;
    }

    @Override
    protected Race suggestThis() {
        return Race.DWARF;
    }
}
