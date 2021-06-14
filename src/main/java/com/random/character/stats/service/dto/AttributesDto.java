package com.random.character.stats.service.dto;

import com.random.character.stats.model.Attribute;
import lombok.Data;

import java.util.List;

@Data
public class AttributesDto {
    
    private Attribute strength;
    private Attribute dexterity;
    private Attribute constitution;
    private Attribute intelligence;
    private Attribute wisdom;
    private Attribute charisma;
    private List<Attribute> attributesList;
    
    public AttributesDto(List<Attribute> attributeList) {
        this.attributesList = attributeList;
        this.strength = attributeList.get(0);
        this.dexterity = attributeList.get(1);
        this.constitution = attributeList.get(2);
        this.intelligence = attributeList.get(3);
        this.wisdom = attributeList.get(4);
        this.charisma = attributeList.get(5);
    }

}
