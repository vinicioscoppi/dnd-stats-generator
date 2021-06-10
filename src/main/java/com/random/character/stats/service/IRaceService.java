package com.random.character.stats.service;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;

import java.util.List;

public interface IRaceService {
    Race suggestRace(List<Attribute> attributes);
}
