package com.random.character.stats.service.implementation;

import com.random.character.stats.TestHelper;
import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;
import com.random.character.stats.service.implementation.responsibility.*;
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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RaceServiceTest {

    @InjectMocks
    private RaceService service;

    @Mock
    private ApplicationContext context;

    @Test
    public void itShouldSuggestHumanWhenThereAreThreeAttributesWithValueTenOrEleven() {
        var attributes = List.of(
                new Attribute(10, TestHelper.TEST_MODIFIER),
                new Attribute(11, TestHelper.TEST_MODIFIER),
                new Attribute(TestHelper.TEST_VALUE, TestHelper.TEST_MODIFIER),
                new Attribute(TestHelper.TEST_VALUE, TestHelper.TEST_MODIFIER),
                new Attribute(10, TestHelper.TEST_MODIFIER),
                new Attribute(TestHelper.TEST_VALUE, TestHelper.TEST_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.HUMAN));
    }

    @Test
    public void itShouldSuggestOrcWhenStrengthIsHigherThanTenAndIntelligenceIsLowerThanTen() {
        var attributes = List.of(
                new Attribute(11, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.ORC));
    }

    @Test
    public void itShouldSuggestHalflingWhenDexterityIsHigherThanTenAndStrengthIsLowerThanTen() {
        var attributes = List.of(
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(11, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.HALFLING));
    }

    @Test
    public void itShouldSuggestDwarfWhenConstitutionIsHigherThenTenAndCharismaIsLowerThanTen() {
        var attributes = List.of(
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(11, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.DWARF));
    }

    @Test
    public void itShouldSuggestGnomeWhenIntelligenceIsHigherThanTenAndStrengthIsLowerThanTen() {
        var attributes = List.of(
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(11, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.GNOME));
    }

    @Test
    public void itShouldSuggestElfWhenWisdomIsHigherThanTenAndDexterityIsHigherThanTen() {
        var attributes = List.of(
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(11, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(11, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.ELF));
    }

    @Test
    public void itShouldSuggestHalfElfWhenCharismaIsHigherThanTenAndWisdomIsHigherThanTen() {
        var attributes = List.of(
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(11, TestHelper.TEST_MODIFIER),
                new Attribute(11, TestHelper.TEST_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.HALF_ELF));
    }

    @Test
    public void itShouldRespectTheChainOfResponsibility() {
        var attributes = List.of(
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER),
                new Attribute(9, TestHelper.TEST_MODIFIER)
        );

        var suggestedRace = service.suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.UNDETERMINED));
    }
}
