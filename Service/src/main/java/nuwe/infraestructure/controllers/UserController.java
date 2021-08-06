package nuwe.infraestructure.controllers;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nuwe.application.exceptions.AlreadyExistsException;
import nuwe.application.exceptions.WrongPasswordException;
import nuwe.application.services.UserService;
import nuwe.infraestructure.dto.UserDTO;

@RestController
//@RequestMapping("/user")
public class UserController {

	//TODO login with username and password
	//TODO register with username, password and email

	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public String login(@Valid @RequestBody UserDTO user) throws NoSuchElementException, WrongPasswordException {
		String answer = userService.login(user.getUsername(), user.getPassword());		
		return answer;
	}
	

	@PostMapping("/register")
	public String newUser(@Valid @RequestBody UserDTO user) throws AlreadyExistsException {
		String answer = userService.newUser(user);		
		return answer;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String noValidExpcetion(MethodArgumentNotValidException e) {
		return "Validation Json problem:\n" + e.getFieldError().getDefaultMessage();
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String noELementFoundException(NoSuchElementException e) {
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
