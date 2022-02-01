package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.PokemonDuplicateException;
import com.example.demo.exception.PokemonValidationException;
import com.example.demo.model.Pokemon;
import com.example.demo.usecase.PokemonUseCase;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private PokemonUseCase pokemonUseCase;

	@RequestMapping(method = RequestMethod.GET)
	public List<Pokemon> getAll() {
		return pokemonUseCase.getAll();
	}

	@RequestMapping(value = "/{number}", method = RequestMethod.GET)
	public Pokemon getByNumber(@PathVariable("number") Integer number) {
		return pokemonUseCase.getByNumber(number);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void save(@RequestBody Pokemon pokemon) throws PokemonValidationException, PokemonDuplicateException {
		pokemonUseCase.save(pokemon);
	}

	@RequestMapping(value = "/addAll", method = RequestMethod.POST)
	public void save(@RequestBody List<Pokemon> pokemonList) throws PokemonValidationException {
		pokemonUseCase.saveAll(pokemonList);
	}
	
	@RequestMapping(value = "/{number}", method = RequestMethod.PUT)
	public void updateByNumber(@PathVariable("number") Integer number, @RequestBody Pokemon pokemon) throws PokemonValidationException {
		pokemonUseCase.updateByNumber(number, pokemon);
	}

	@RequestMapping(value = "/{number}", method = RequestMethod.DELETE)
	public void removeByNumber(@PathVariable("number") Integer number) {
		pokemonUseCase.removeByNumber(number);
	}
}
