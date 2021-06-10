package com.random.character.stats.service.implementation;

import com.random.character.stats.service.IDiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DiceService implements IDiceService {

    @Autowired
    private Random random;

    public Integer rollOneDSix() {
        return 1 + random.nextInt(5);
    }

    public List<Integer> rollOneDSixNTimes(int n) {
        var roll = new ArrayList<Integer>();
        for (var i = 0; i < n; i++) {
            roll.add(rollOneDSix());
        }
        return roll;
    }
}
