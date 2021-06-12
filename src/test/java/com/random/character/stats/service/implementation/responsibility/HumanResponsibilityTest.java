package com.random.character.stats.service.implementation.responsibility;

import com.random.character.stats.TestHelper;
import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.Race;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HumanResponsibilityTest {

    @Test
    public void itShouldSuggestHumanWhenThereAreThreeAttributesWithValueTenOrEleven() {
        var attributes = List.of(
                new Attribute(10, TestHelper.ANY_MODIFIER),
                new Attribute(11, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER),
                new Attribute(10, TestHelper.ANY_MODIFIER),
                new Attribute(TestHelper.ANY_VALUE, TestHelper.ANY_MODIFIER)
        );

        var suggestedRace = new HumanResponsibility().suggestRace(attributes);

        assertThat(suggestedRace, equalTo(Race.HUMAN));
    }
}
