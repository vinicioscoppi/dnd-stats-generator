package com.random.character.stats.api;

import com.random.character.stats.model.Character;
import com.random.character.stats.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private ICharacterService characterService;

    @ResponseBody
    @GetMapping(path = "/classic")
    public Character getClassicStats() {
        return characterService.getClassicStats();
    }

    @ResponseBody
    @GetMapping(path = "/standard")
    public Character getStandardStats() {
        return characterService.getStandardStats();
    }

    @ResponseBody
    @GetMapping(path = "/epic")
    public Character getEpicStats() {
        return characterService.getEpicStats();
    }
}
