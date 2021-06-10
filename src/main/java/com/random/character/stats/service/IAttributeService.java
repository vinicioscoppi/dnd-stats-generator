package com.random.character.stats.service;

import com.random.character.stats.model.Attribute;

import java.util.List;

public interface IAttributeService {
    List<Attribute> getAttributes(IRollStrategy rollStrategy);
}
