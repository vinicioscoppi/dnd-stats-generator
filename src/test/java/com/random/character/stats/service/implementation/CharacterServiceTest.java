package com.random.character.stats.service.implementation;

import com.random.character.stats.TestHelper;
import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Character;
import com.random.character.stats.model.Race;
import com.random.character.stats.model.exception.InvalidRollsException;
import com.random.character.stats.service.IAttributeService;
import com.random.character.stats.service.IRaceService;
import com.random.character.stats.service.IRollStrategy;
import com.random.character.stats.service.implementation.strategy.ClassicStrategy;
import com.random.character.stats.service.implementation.strategy.EpicStrategy;
import com.random.character.stats.service.implementation.strategy.StandardStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTest {

    @InjectMocks
    private CharacterService service;

    @Mock
    private IAttributeService attributeService;

    @Mock
    private IRaceService raceService;

    @Mock
    private ApplicationContext context;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldReturnTheExpectedClassicCharacter() {
        List<Attribute> attributes = TestHelper.getTestAttributeList();
        Character expectedCharacter = new Character(attributes);
        when(attributeService.getAttributes(any(IRollStrategy.class))).thenReturn(attributes);
        when(context.getBean(ClassicStrategy.class)).thenReturn(new ClassicStrategy());
        when(raceService.suggestRace(anyList())).thenReturn(Race.UNDETERMINED);

        Character returnedCharacter = service.getClassicStats();

        assertThat(returnedCharacter, equalTo(expectedCharacter));
    }

    @Test
    public void itShouldReturnTheExpectedStandardCharacter() {
        List<Attribute> attributes = TestHelper.getTestAttributeList();
        Character expectedCharacter = new Character(attributes);
        when(attributeService.getAttributes(any(IRollStrategy.class))).thenReturn(attributes);
        when(context.getBean(StandardStrategy.class)).thenReturn(new StandardStrategy());
        when(raceService.suggestRace(anyList())).thenReturn(Race.UNDETERMINED);

        Character returnedCharacter = service.getStandardStats();

        assertThat(returnedCharacter, equalTo(expectedCharacter));
    }

    @Test
    public void itShouldReturnTheExpectedEpicCharacter() {
        List<Attribute> attributes = TestHelper.getTestAttributeList();
        Character expectedCharacter = new Character(attributes);
        when(attributeService.getAttributes(any(IRollStrategy.class))).thenReturn(attributes);
        when(context.getBean(EpicStrategy.class)).thenReturn(new EpicStrategy());
        when(raceService.suggestRace(anyList())).thenReturn(Race.UNDETERMINED);

        Character returnedCharacter = service.getEpicStats();

        assertThat(returnedCharacter, equalTo(expectedCharacter));
    }

    @Test
    public void itShouldThrowInvalidRollsExceptionWhenAttributeRollsListIsNull() {
        when(attributeService.getAttributes(any(IRollStrategy.class))).thenReturn(null);

        when(context.getBean(ClassicStrategy.class)).thenReturn(new ClassicStrategy());
        when(context.getBean(StandardStrategy.class)).thenReturn(new StandardStrategy());
        when(context.getBean(EpicStrategy.class)).thenReturn(new EpicStrategy());

        assertThrows(InvalidRollsException.class, () -> {
            service.getClassicStats();
        });
        assertThrows(InvalidRollsException.class, () -> {
            service.getEpicStats();
        });
        assertThrows(InvalidRollsException.class, () -> {
            service.getStandardStats();
        });

    }

    @Test
    public void itShouldThrowInvalidRollsExceptionWhenAttributeRollsListLengthIsDifferentThanStatsCount() {
        List<Attribute> invalidAttributeRolls = List.of(new Attribute(10, 0));
        when(attributeService.getAttributes(any(IRollStrategy.class))).thenReturn(invalidAttributeRolls);

        when(context.getBean(ClassicStrategy.class)).thenReturn(new ClassicStrategy());
        when(context.getBean(StandardStrategy.class)).thenReturn(new StandardStrategy());
        when(context.getBean(EpicStrategy.class)).thenReturn(new EpicStrategy());

        assertThrows(InvalidRollsException.class, () -> {
            service.getClassicStats();
        });
        assertThrows(InvalidRollsException.class, () -> {
            service.getEpicStats();
        });
        assertThrows(InvalidRollsException.class, () -> {
            service.getStandardStats();
        });
    }

    @Test
    public void itShouldNotThrowInvalidRollsExceptionWhenAttributeRollsListLengthEqualsToStatsCount() {
        int statsCount = 6;
        List<Attribute> attributes = new ArrayList<>();
        for (var i = 0; i < statsCount; i++) {
            attributes.add(new Attribute(10, 0));
        }

        when(attributeService.getAttributes(any(IRollStrategy.class))).thenReturn(attributes);

        when(context.getBean(ClassicStrategy.class)).thenReturn(new ClassicStrategy());
        when(context.getBean(StandardStrategy.class)).thenReturn(new StandardStrategy());
        when(context.getBean(EpicStrategy.class)).thenReturn(new EpicStrategy());

        assertDoesNotThrow(() -> {
            service.getClassicStats();
        });
        assertDoesNotThrow(() -> {
            service.getEpicStats();
        });
        assertDoesNotThrow(() -> {
            service.getStandardStats();
        });
    }
}
