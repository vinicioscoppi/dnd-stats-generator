package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.TestHelper;
import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DwarfResponsibilityTest {

    @Test
    public void itShouldSuggestDwarfWhenConstitutionIsHigherThenTenAndCharismaIsLowerThanTen() {
        var attributes = List.of(
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(11, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(9, TestHelper.ANY_MODIFIER)
        );

        var suggestedRace = new DwarfResponsibility().suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.DWARF));
    }
}
