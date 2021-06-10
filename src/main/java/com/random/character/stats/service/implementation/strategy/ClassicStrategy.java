package com.random.character.stats.service.implementation.strategy;

import com.random.character.stats.service.IDiceService;
import com.random.character.stats.service.IRollStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassicStrategy implements IRollStrategy {

    @Autowired
    private IDiceService diceService;

    @Override
    public Integer roll() {
        return diceService.rollOneDSixNTimes(3).stream().reduce(Integer::sum).orElse(10);
    }
}
