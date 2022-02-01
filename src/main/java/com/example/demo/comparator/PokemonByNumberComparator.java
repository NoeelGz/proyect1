package com.example.demo.comparator;

import java.util.Comparator;

import com.example.demo.model.Pokemon;

public class PokemonByNumberComparator implements Comparator<Pokemon> {

	@Override
	public int compare(Pokemon a, Pokemon b) {
		return a.getNumber() < b.getNumber() ? -1 : 1;
	}

}
