package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Race;
import com.random.character.stats.service.dto.AttributesDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HumanResponsibility extends RaceResponsibility {

    public HumanResponsibility(OrcResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    protected boolean appliesToRace(AttributesDto attributesDto) {
        return attributesDto.getAttributesList()
                            .stream()
                            .filter(attr -> attr.getValue() == 10 || attr.getValue() == 11)
                            .count() >= 3;
    }

    @Override
    protected Race suggestThis() {
        return Race.HUMAN;
    }
}
