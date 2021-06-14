package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.TestHelper;
import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;
import com.random.character.stats.service.dto.AttributesDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UndeterminedRaceResponsibilityTest {

    @Test
    public void itShouldSuggestUndeterminedRace() {
        var attributes = new AttributesDto(List.of(
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER)
        ));

        var suggestedRace = new UndeterminedRaceResponsibility().suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.UNDETERMINED));
    }
}
