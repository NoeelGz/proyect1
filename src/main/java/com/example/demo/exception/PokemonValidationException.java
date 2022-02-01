package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class PokemonValidationException extends Exception {
	
	public PokemonValidationException(String msg) {
		super(msg);
	}

}
