package com.random.character.stats.service.implementation;

import com.random.character.stats.TestHelper;
import com.random.character.stats.model.Attribute;
import com.random.character.stats.model.exception.InvalidModifierException;
import com.random.character.stats.model.exception.InvalidValueException;
import com.random.character.stats.service.IRollStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AttributeServiceTest {

    @Mock
    private ModifierService modifierDeterminationService;

    @InjectMocks
    private AttributeService service;

    @Mock
    private IRollStrategy rollStrategy;

    @Test
    public void itShouldReturnTheExpectedStandardAttributesDto() {
        var expectedAttributesDto = TestHelper.getTestAttributesDto();
        when(modifierDeterminationService.determineModifierFromValue(anyInt())).thenReturn(TestHelper.ANY_MODIFIER);
        when(rollStrategy.roll()).thenReturn(TestHelper.ANY_VALID_VALUE);

        var returnedAttributesDto = service.getAttributes(rollStrategy);

        assertThat(returnedAttributesDto, equalTo(expectedAttributesDto));
    }

    @Test
    public void itShouldThrowInvalidValueExceptionWhenValueIsInvalid() {
        when(rollStrategy.roll()).thenReturn(2).thenReturn(19);

        assertThrows(InvalidValueException.class, () -> {
            service.getAttributes(rollStrategy);
        });
        assertThrows(InvalidValueException.class, () -> {
            service.getAttributes(rollStrategy);
        });
    }

    @Test
    public void itShouldThrowInvalidModifierExceptionWhenModifierIsInvalid() {
        when(rollStrategy.roll()).thenReturn(TestHelper.ANY_VALID_VALUE);
        when(modifierDeterminationService.determineModifierFromValue(anyInt())).thenReturn(-4).thenReturn(5);

        assertThrows(InvalidModifierException.class, () -> {
            service.getAttributes(rollStrategy);
        });
        assertThrows(InvalidModifierException.class, () -> {
            service.getAttributes(rollStrategy);
        });
    }
}
