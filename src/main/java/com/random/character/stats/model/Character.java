package com.random.character.stats.model;

import com.random.character.stats.service.dto.AttributesDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Character {

    private final Race race;

    private final Attribute strength;
    private final Attribute dexterity;
    private final Attribute constitution;
    private final Attribute intelligence;
    private final Attribute wisdom;
    private final Attribute charisma;

    public Character(AttributesDto attributesDto, Race race) {
        this.race = race;
        this.strength = attributesDto.getStrength();
        this.dexterity = attributesDto.getDexterity();
        this.constitution = attributesDto.getConstitution();
        this.intelligence = attributesDto.getIntelligence();
        this.wisdom = attributesDto.getWisdom();
        this.charisma = attributesDto.getCharisma();
    }

    public Character(AttributesDto attributesDto) {
        this(attributesDto, Race.UNDETERMINED);
    }
}
