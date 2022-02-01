package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokemonRepository;

@Service
@Transactional
public class PokemonService {
	
	@Autowired
	private PokemonRepository pokemonRepository;


	public List<Pokemon> findAll() {
		return pokemonRepository.findAll();
	}

	public Pokemon findByNumber( Integer number) {
		return pokemonRepository.findByNumber(number);
	}

	public void save(Pokemon pokemon){
		pokemonRepository.save(pokemon);
	}

	public void deleteByNumber(Integer number) {
		pokemonRepository.deleteByNumber(number);
	}
	
	public boolean exist(Integer number, String name) {
		return pokemonRepository.existsByNumberOrName(number, name);
	}
}
