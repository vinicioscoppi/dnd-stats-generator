package com.random.character.stats.service.implementation;

import com.random.character.stats.service.IDiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DiceService implements IDiceService {

    @Autowired
    private Random random;

    public Integer rollOneDSix() {
        return 1 + random.nextInt(5);
    }

    public List<Integer> rollOneDSixNTimes(int n) {
        return Stream.generate(this::rollOneDSix).limit(n).collect(Collectors.toList());
    }
}
