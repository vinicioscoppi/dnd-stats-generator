package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Race;
import com.random.character.stats.service.dto.AttributesDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GnomeResponsibility extends RaceResponsibility {

    public GnomeResponsibility(HalfElfResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    protected boolean appliesToRace(AttributesDto attributesDto) {
        return attributesDto.getIntelligence().getValue() > 10 &&
               attributesDto.getStrength().getValue() < 10;
    }

    @Override
    protected Race suggestThis() {
        return Race.GNOME;
    }
}
