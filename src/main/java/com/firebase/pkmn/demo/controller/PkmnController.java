package com.firebase.pkmn.demo.controller;

import com.firebase.pkmn.demo.entity.Pokemon;
import com.firebase.pkmn.demo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/pkmn")
public class PkmnController {

    @Autowired
    private PokemonService pokemonService;


    @GetMapping("/pokemon/{name}")
    public Pokemon getPokemon(@PathVariable String name) throws ExecutionException, InterruptedException {

        return pokemonService.getPokemon(name);
    }

    @GetMapping("/pokemon")
    public List<Pokemon> getAllPokemon() throws ExecutionException, InterruptedException {

        return pokemonService.getAllPokemon();
    }
}
