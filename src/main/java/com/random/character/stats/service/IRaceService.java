package com.random.character.stats.service;

import com.random.character.stats.model.Race;
import com.random.character.stats.service.dto.AttributesDto;

public interface IRaceService {
    Race suggestRace(AttributesDto attributesDto);
}
