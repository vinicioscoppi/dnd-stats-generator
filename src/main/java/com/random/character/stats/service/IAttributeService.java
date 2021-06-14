package com.random.character.stats.service;

import com.random.character.stats.model.Attribute;
import com.random.character.stats.service.dto.AttributesDto;

import java.util.List;

public interface IAttributeService {
    AttributesDto getAttributes(IRollStrategy rollStrategy);
}
