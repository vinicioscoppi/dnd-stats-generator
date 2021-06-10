package com.random.character.stats.service.implementation;

import com.random.character.stats.model.Character;
import com.random.character.stats.model.exception.InvalidRollsException;
import com.random.character.stats.service.IAttributeService;
import com.random.character.stats.service.ICharacterService;
import com.random.character.stats.service.IRaceService;
import com.random.character.stats.service.IRollStrategy;
import com.random.character.stats.service.implementation.strategy.ClassicStrategy;
import com.random.character.stats.service.implementation.strategy.EpicStrategy;
import com.random.character.stats.service.implementation.strategy.StandardStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CharacterService implements ICharacterService {

    private static final int STATS_COUNT = 6;

    @Autowired
    private IAttributeService attributeService;

    @Autowired
    private IRaceService raceService;

    @Autowired
    private ApplicationContext context;


    @Override
    public Character getClassicStats() {
        return getCharacter(context.getBean(ClassicStrategy.class));
    }

    @Override
    public Character getStandardStats() {
        return getCharacter(context.getBean(StandardStrategy.class));
    }

    @Override
    public Character getEpicStats() {
        return getCharacter(context.getBean(EpicStrategy.class));
    }

    private Character getCharacter(IRollStrategy rollStrategy) {
        var attributes = attributeService.getAttributes(rollStrategy);
        if(attributes == null || attributes.size() != STATS_COUNT) {
            throw new InvalidRollsException(attributes);
        }
        return new Character(attributes, raceService.suggestRace(attributes));
    }
}
