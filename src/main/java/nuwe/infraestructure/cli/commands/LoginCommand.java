package nuwe.infraestructure.cli.commands;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nuwe.application.services.UserService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "login", mixinStandardHelpOptions = true, description = "Login user with username and password")
public class LoginCommand implements Runnable {

	private Scanner sc = new Scanner(System.in);
	
	@Option(names = {"-u", "username"}, required = false, description = "Enter the username=\"\" or -u=\"\"" )
	private String username;
	
	@Option(names = {"-p", "password"}, required = false, description = "Enter the username=\"\" or -u=\"\"" )
	private String password;

	@Autowired
	private UserService userService;

	@Override
	public void run() {
		System.out.println("Has seleccionado hacer login con tu usuario y contraseña.");

		if(username == null) {
		System.out.println("Usuario:");
		username = sc.next();
		}
		
		if (password == null) {
			System.out.println("Password:");
			password = sc.next();			
		}

		try {
			if (userService.login(username, password)) {
				System.out.println("Usuario Logueado con éxito.\n¡Bienvenid@ " + username +"!");
			} else {
				System.out.println("Password erróneo.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("El usuario introducido no existe");
		}
	}
}
