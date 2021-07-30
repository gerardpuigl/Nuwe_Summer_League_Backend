package nuwe.infraestructure.cli.commands;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;

@Component
@Command(name = "login" , mixinStandardHelpOptions = true, description = "Login user with username and password")
public class LoginCommand implements Runnable {

	private Scanner sc = new Scanner(System.in);
	private String username;
	private String password; 
	
	@Override
	public void run() {
		System.out.println("Has seleccionado loguearte con tu usuario y contraseña.");
		System.out.println("Usuario:");
		username = sc.next();
		System.out.println("Password:");
		password = sc.next();
		System.out.println("Hola " + username + ". Tu password es: " + password);
	}
}
