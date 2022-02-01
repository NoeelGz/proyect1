package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class PokemonDuplicateException extends Exception {

	public PokemonDuplicateException(String msg) {
		super(msg);
	}

}
