package com.random.character.stats.service;

import java.util.List;

public interface IDiceService {
    Integer rollOneDSix();
    List<Integer> rollOneDSixNTimes(int n);
}
