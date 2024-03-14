package com.example.exceptionhandling;

import com.example.exceptionhandling.pokemon.PokemonObjectMother;
import com.example.exceptionhandling.pokemon.PokemonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class DbInit implements ApplicationRunner {

    private PokemonRepository pokemonRepository;

    public void run(ApplicationArguments args) {
        log.info("Generating sample data for the database...");
        pokemonRepository.save(PokemonObjectMother.createBulbasaur());
    }

}
