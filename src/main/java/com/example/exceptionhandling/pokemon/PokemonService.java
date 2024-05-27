package com.example.exceptionhandling.pokemon;

import com.example.exceptionhandling.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public Pokemon getPokemonNoException(Integer pokemonId) {
        return pokemonRepository.findById(pokemonId).orElse(null);
    }

    public Pokemon getPokemon(Integer pokemonId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElse(null);
        if (pokemon == null) {
            // todo throws exception
            throw new EntityNotFoundException(Pokemon.class, "pokemonId", pokemonId.toString());
        }
        return pokemon;
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public List<Pokemon> getPokemonCollection(PokemonCollection pokemonCollection) {
        List<Pokemon> pokemons = new ArrayList<>();

        for (Integer pokemonId : pokemonCollection.getPokemonIds()) {
            Pokemon pokemon = pokemonRepository.findById(pokemonId).orElse(null);
            if (pokemon == null) {
                // todo throws exception
            }
            pokemons.add(pokemon);
        }
        return pokemons;
    }
}
