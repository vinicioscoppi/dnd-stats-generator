package com.random.character.stats.service.implementation;

import com.random.character.stats.TestHelper;
import com.random.character.stats.model.Character;
import com.random.character.stats.model.Race;
import com.random.character.stats.service.IAttributeService;
import com.random.character.stats.service.IRaceService;
import com.random.character.stats.service.IRollStrategy;
import com.random.character.stats.service.dto.AttributesDto;
import com.random.character.stats.service.implementation.strategy.ClassicStrategy;
import com.random.character.stats.service.implementation.strategy.EpicStrategy;
import com.random.character.stats.service.implementation.strategy.StandardStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
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

    @Test
    public void itShouldReturnTheExpectedClassicCharacter() {
        var attributes = TestHelper.getTestAttributesDto();
        var expectedCharacter = new Character(attributes);
        when(attributeService.getAttributes(any(IRollStrategy.class))).thenReturn(attributes);
        when(context.getBean(ClassicStrategy.class)).thenReturn(new ClassicStrategy());
        when(raceService.suggestRace(any(AttributesDto.class))).thenReturn(Race.UNDETERMINED);

        var returnedCharacter = service.getClassicStats();

        assertThat(returnedCharacter, equalTo(expectedCharacter));
    }

    @Test
    public void itShouldReturnTheExpectedStandardCharacter() {
        var attributes = TestHelper.getTestAttributesDto();
        var expectedCharacter = new Character(attributes);
        when(attributeService.getAttributes(any(IRollStrategy.class))).thenReturn(attributes);
        when(context.getBean(StandardStrategy.class)).thenReturn(new StandardStrategy());
        when(raceService.suggestRace(any(AttributesDto.class))).thenReturn(Race.UNDETERMINED);

        var returnedCharacter = service.getStandardStats();

        assertThat(returnedCharacter, equalTo(expectedCharacter));
    }

    @Test
    public void itShouldReturnTheExpectedEpicCharacter() {
        var attributes = TestHelper.getTestAttributesDto();
        var expectedCharacter = new Character(attributes);
        when(attributeService.getAttributes(any(IRollStrategy.class))).thenReturn(attributes);
        when(context.getBean(EpicStrategy.class)).thenReturn(new EpicStrategy());
        when(raceService.suggestRace(any(AttributesDto.class))).thenReturn(Race.UNDETERMINED);

        var returnedCharacter = service.getEpicStats();

        assertThat(returnedCharacter, equalTo(expectedCharacter));
    }
}
