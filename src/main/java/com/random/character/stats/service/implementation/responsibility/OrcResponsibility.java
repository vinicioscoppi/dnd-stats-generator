package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Race;
import com.random.character.stats.service.dto.AttributesDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrcResponsibility extends RaceResponsibility {

    public OrcResponsibility(DwarfResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    protected boolean appliesToRace(AttributesDto attributesDto) {
        return attributesDto.getStrength().getValue() > 10 &&
               attributesDto.getIntelligence().getValue() < 10;
    }

    @Override
    protected Race suggestThis() {
        return Race.ORC;
    }
}
