package com.random.character.stats.service.implementation;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;
import com.random.character.stats.service.IRaceService;
import com.random.character.stats.service.implementation.responsibility.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService implements IRaceService {

    public Race suggestRace(List<Attribute> attributes) {
        return new HumanResponsibility(
                   new OrcResponsibility(
                            new DwarfResponsibility(
                                    new ElfResponsibility(
                                        new HalflingResponsibility(
                                                new GnomeResponsibility(
                                                        new HalfElfResponsibility(
                                                                new UndeterminedRaceResponsibility())))))))
                .suggestRace(attributes);
    }
}
