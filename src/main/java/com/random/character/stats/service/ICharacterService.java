package com.random.character.stats.service;

import com.random.character.stats.model.Character;

public interface ICharacterService {
    Character getClassicStats();
    Character getStandardStats();
    Character getEpicStats();
}
