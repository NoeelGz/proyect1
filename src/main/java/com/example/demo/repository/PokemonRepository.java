package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

	public Pokemon findByNumber(Integer number);
	public void deleteByNumber(Integer number);
	public boolean existsByNumberOrName(Integer number, String name);
}
