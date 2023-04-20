package br.com.fabio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RequiredObjectIsNullFoundException(String ms) {
		super(ms);
	}

	public RequiredObjectIsNullFoundException() {
		super("It is not allowed to persist a null object!");
	}


}
