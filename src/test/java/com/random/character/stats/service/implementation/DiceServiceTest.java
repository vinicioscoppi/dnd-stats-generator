package com.random.character.stats.service.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DiceServiceTest {

    @Mock
    private Random random;

    @InjectMocks
    private DiceService diceService;

    @Test
    public void itShouldRollTheExpectedAmountOfTimes() {
        when(random.nextInt(anyInt())).thenReturn(1);
        var times = 5;

        var returnedList = diceService.rollOneDSixNTimes(times);

        verify(random, times(times)).nextInt(anyInt());
        assertThat(returnedList.size(), equalTo(times));
    }
}
