package com.random.character.stats;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class StatsConfiguration {

    @Bean
    public Random getRandom(){
        return new Random();
    }
}
