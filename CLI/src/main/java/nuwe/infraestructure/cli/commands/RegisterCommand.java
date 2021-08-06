package nuwe.infraestructure.cli.commands;

import java.util.Scanner;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "register" , mixinStandardHelpOptions = true, description = "Register a new user [more info with \"register -h\"]\"")
public class RegisterCommand implements Runnable{

	@Option(names = {"-u", "username"}, required = false, description = "Enter username on execution" )
	private String username;
	
	@Option(names = {"-p", "password"}, required = false, description = "Enter password on execution" )
	private String password;

	@Option(names = {"-e", "email"}, required = false, description = "Enter email on execution" )
	private String email;
	
	private Scanner sc = new Scanner(System.in);

	@Override
	public void run() {
		System.out.println("Selected register new user.");

//		User user = new User();
		if (username == null) username = ask("username:");
		if (password == null) password = ask("password:");
		if (email == null) email = ask("email:");

//		user.setUsername(username);
//		user.setPassword(password);
//		user.setEmail(email);
		
		try {
//			userService.newUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	private String ask(String question) {
		System.out.println(question);
		return sc.next();
	}

}
