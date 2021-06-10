package com.random.character.stats.model;

import com.random.character.stats.model.exception.InvalidRollsException;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

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

    public Character(List<Attribute> attributeRolls, Race race) {
        this.race = race;
        this.strength = attributeRolls.get(0);
        this.dexterity = attributeRolls.get(1);
        this.constitution = attributeRolls.get(2);
        this.intelligence = attributeRolls.get(3);
        this.wisdom = attributeRolls.get(4);
        this.charisma = attributeRolls.get(5);
    }

    public Character(List<Attribute> attributeRolls) {
        this(attributeRolls, Race.UNDETERMINED);
    }
}
