package br.com.fabio.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.fabio.exceptions.ExceptionResponse;
import br.com.fabio.exceptions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception ex, WebRequest request){
		ExceptionResponse exResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handlerNotFoundExceptions(Exception ex, WebRequest request){
		ExceptionResponse exResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadRequest.class)
	public final ResponseEntity<ExceptionResponse> handlerBadRequestExceptions(Exception ex, WebRequest request){
		ExceptionResponse exResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.NOT_FOUND);
	}

}
