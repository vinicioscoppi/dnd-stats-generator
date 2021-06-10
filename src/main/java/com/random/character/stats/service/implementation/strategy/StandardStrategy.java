package com.random.character.stats.service.implementation.strategy;

import com.random.character.stats.service.IDiceService;
import com.random.character.stats.service.IRollStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class StandardStrategy implements IRollStrategy {

    @Autowired
    private IDiceService diceService;

    @Override
    public Integer roll() {
        var rolls = diceService.rollOneDSixNTimes(4);
        rolls.remove(Collections.min(rolls));
        return rolls.stream().reduce(Integer::sum).orElse(10);
    }
}
