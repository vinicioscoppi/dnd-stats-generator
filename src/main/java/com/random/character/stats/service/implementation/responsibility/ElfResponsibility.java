package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Race;
import com.random.character.stats.service.dto.AttributesDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ElfResponsibility extends RaceResponsibility {

    public ElfResponsibility(HalflingResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    protected boolean appliesToRace(AttributesDto attributesDto) {
        return attributesDto.getIntelligence().getValue() >= 12 &&
               attributesDto.getDexterity().getValue() >= 12;
    }

    @Override
    protected Race suggestThis() {
        return Race.ELF;
    }
}
