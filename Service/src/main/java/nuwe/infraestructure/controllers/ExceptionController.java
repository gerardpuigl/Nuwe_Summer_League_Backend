package nuwe.infraestructure.controllers;

import java.util.NoSuchElementException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import nuwe.application.exceptions.AlreadyExistsException;
import nuwe.application.exceptions.WrongPasswordException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String noValidExpcetion(MethodArgumentNotValidException e) {
		return "Validation Json problem:\n" + e.getFieldError().getDefaultMessage();
	}
	
	@ExceptionHandler({NoSuchElementException.class,NotFoundException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String noELementFoundException(Exception e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(WrongPasswordException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String wrongPasswordException(WrongPasswordException e) {
		return e.getMessage();
	}	
	
	@ExceptionHandler(AlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String alrreadyExistsException(AlreadyExistsException e) {
		return e.getMessage();
	}
}
