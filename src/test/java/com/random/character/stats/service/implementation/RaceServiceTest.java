package com.random.character.stats.service.implementation;

import com.random.character.stats.TestHelper;
import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;
import com.random.character.stats.service.implementation.responsibility.DwarfResponsibility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(MockitoExtension.class)
public class RaceServiceTest {

    @InjectMocks
    private RaceService service;

    @Mock
    private ApplicationContext context;

    @Test
    public void itShouldSuggestHumanOverOrc() {
        var attributes = List.of(
                new Attribute(12, TestHelper.ANY_MODIFIER),
                new Attribute(10, TestHelper.ANY_MODIFIER),
                new Attribute(10, TestHelper.ANY_MODIFIER),
                new Attribute(9, TestHelper.ANY_MODIFIER),
                new Attribute(10, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.HUMAN));
    }

    @Test
    public void itShouldSuggestOrcOverDwarf() {
        var attributes = List.of(
                new Attribute(12, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(12, TestHelper.ANY_MODIFIER),
                new Attribute(9, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(9, TestHelper.ANY_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.ORC));
    }

    @Test
    public void itShouldSuggestDwarfOverElf() {
        var attributes = List.of(
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(12, TestHelper.ANY_MODIFIER),
                new Attribute(12, TestHelper.ANY_MODIFIER),
                new Attribute(12, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(9, TestHelper.ANY_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.DWARF));
    }

    @Test
    public void itShouldSuggestElfOverHalfling() {
        var attributes = List.of(
                new Attribute(9, TestHelper.ANY_MODIFIER),
                new Attribute(12, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(12, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.ELF));
    }

    @Test
    public void itShouldSuggestHalflingOverGnome() {
        var attributes = List.of(
                new Attribute(9, TestHelper.ANY_MODIFIER),
                new Attribute(11, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(11, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.HALFLING));
    }

    @Test
    public void itShouldSuggestGnomeOverHalfElf() {
        var attributes = List.of(
                new Attribute(9, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(11, TestHelper.ANY_MODIFIER),
                new Attribute(12, TestHelper.ANY_MODIFIER),
                new Attribute(12, TestHelper.ANY_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.GNOME));
    }

    @Test
    public void itShouldSuggestHalfElfOverUndeterminedRace() {
        var attributes = List.of(
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(12, TestHelper.ANY_MODIFIER),
                new Attribute(12, TestHelper.ANY_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.HALF_ELF));
    }
}
