package com.random.character.stats.service.implementation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(MockitoExtension.class)
public class ModifierDeterminationServiceTest {

    @InjectMocks
    private ModifierService service;

    @Test
    public void itShouldDetermineTheExpectedModifier() {
        Integer valueEighteenModifier = 4;
        Integer valueTenModifier = 0;
        Integer valueThreeModifier = -3;

        Integer returnedValueEighteenModifier = service.determineModifierFromValue(18);
        Integer returnedValueTenModifier = service.determineModifierFromValue(10);
        Integer returnedValueThreeModifier = service.determineModifierFromValue(3);

        assertThat(returnedValueEighteenModifier, equalTo(valueEighteenModifier));
        assertThat(returnedValueTenModifier, equalTo(valueTenModifier));
        assertThat(returnedValueThreeModifier, equalTo(valueThreeModifier));
    }
}
