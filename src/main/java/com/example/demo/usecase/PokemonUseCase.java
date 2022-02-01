package com.example.demo.usecase;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.comparator.PokemonByNumberComparator;
import com.example.demo.exception.PokemonDuplicateException;
import com.example.demo.exception.PokemonValidationException;
import com.example.demo.model.Pokemon;
import com.example.demo.service.PokemonService;

@Component
public class PokemonUseCase {

	@Autowired
	private PokemonService pokemonService;

	public List<Pokemon> getAll() {
		var values = pokemonService.findAll();
		Collections.sort(values, new PokemonByNumberComparator());
		
		return values;
	}

	public Pokemon getByNumber(Integer number) {
		return pokemonService.findByNumber(number);
	}

	public void save(Pokemon pokemon) throws PokemonValidationException, PokemonDuplicateException {
		validate(pokemon);
		pokemonService.save(pokemon);
	}

	public void saveAll(List<Pokemon> pokemonList) throws PokemonValidationException {
		for (Pokemon p : pokemonList) {
			try {
				save(p);
			} catch (PokemonDuplicateException e) {
				continue;
			}
		}
	}

	public void updateByNumber(Integer number, Pokemon pokemon) throws PokemonValidationException {
		validateAllParams(pokemon);
		var p = pokemonService.findByNumber(number);

		p.setName(pokemon.getName());
		p.setNumber(pokemon.getNumber());
		p.setType(pokemon.getType());
		p.setWeaknesses(pokemon.getWeaknesses());

		pokemonService.save(p);
	}

	public void removeByNumber(Integer number) {
		pokemonService.deleteByNumber(number);
	}

	private void validate(Pokemon pokemon) throws PokemonValidationException, PokemonDuplicateException {
		validateAllParams(pokemon);
		if (pokemonService.exist(pokemon.getNumber(), pokemon.getName()))
			throw new PokemonDuplicateException("This pokemon already exists");
	}

	private void validateAllParams(Pokemon pokemon) throws PokemonValidationException {
		if (pokemon.getNumber() == null || pokemon.getName() == null || pokemon.getName().trim().isEmpty()
				|| pokemon.getType() == null || pokemon.getType().length == 0 || pokemon.getWeaknesses() == null
				|| pokemon.getWeaknesses().length == 0)
			throw new PokemonValidationException("Invalid Params");
	}
}
