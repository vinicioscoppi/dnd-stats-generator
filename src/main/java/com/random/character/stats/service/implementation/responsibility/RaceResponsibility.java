package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;

import java.util.List;

public abstract class RaceResponsibility {

    protected static final int STRENGTH = 0;
    protected static final int DEXTERITY = 1;
    protected static final int CONSTITUTION = 2;
    protected static final int INTELLIGENCE = 3;
    protected static final int WISDOM = 4;
    protected static final int CHARISMA = 5;

    protected RaceResponsibility nextInChain;

    public abstract Race suggestRace(List<Attribute> attributeList);

    protected abstract boolean appliesToRace(List<Attribute> attributeList);
}
