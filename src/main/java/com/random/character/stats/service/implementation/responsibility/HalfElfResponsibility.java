package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Race;
import com.random.character.stats.service.dto.AttributesDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HalfElfResponsibility extends RaceResponsibility {

    public HalfElfResponsibility(UndeterminedRaceResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    protected boolean appliesToRace(AttributesDto attributesDto) {
        return attributesDto.getCharisma().getValue() > 10 &&
               attributesDto.getWisdom().getValue() > 10;
    }

    @Override
    protected Race suggestThis() {
        return Race.HALF_ELF;
    }
}
