package com.random.character.stats.service.implementation.strategy;

import com.random.character.stats.service.IDiceService;
import com.random.character.stats.service.IRollStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EpicStrategy implements IRollStrategy {

    @Autowired
    private IDiceService diceService;

    @Override
    public Integer roll() {
        var rolls = diceService.rollOneDSixNTimes(4);
        while (areThereOnes(rolls)) {
            rolls = reRollOnes(rolls);
        }
        rolls.remove(Collections.min(rolls));
        return reduceRollsSumming(rolls);
    }

    private Integer reduceRollsSumming(List<Integer> rolls) {
        return rolls.stream().reduce(Integer::sum).orElse(10);
    }

    private boolean areThereOnes(List<Integer> rolls) {
        return rolls.stream().anyMatch(r -> r == 1);
    }

    private List<Integer> reRollOnes(List<Integer> rolls) {
        rolls = rolls.stream().map(r -> {
            r = r == 1 ? diceService.rollOneDSix() : r;
            return r;
        }).collect(Collectors.toList());
        return rolls;
    }
}
