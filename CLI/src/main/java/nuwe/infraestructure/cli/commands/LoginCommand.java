package nuwe.infraestructure.cli.commands;

import java.util.Scanner;

import nuwe.application.services.UserService;
import nuwe.infraestructure.dto.UserDTO;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "login", mixinStandardHelpOptions = true, description = "Login user with username and password. [more info with \"login -h\"]")
public class LoginCommand implements Runnable {

	private Scanner sc = new Scanner(System.in);

	@Option(names = { "-u", "username" }, required = false, description = "Enter username on execution")
	private String username;

	@Option(names = { "-p", "password" }, required = false, description = "Enter password on execution")
	private String password;
	
	private UserService userService = new UserService();

	@Override
	public void run() {
		System.out.println("Selected login with username & password.");
		
		UserDTO user= new UserDTO();

		if (username == null) username = ask("username");
		user.setUsername(username);
		if (password == null) password = ask("password");
		user.setPassword(password);
		
		String answer = userService.login(user);			
		System.out.println(answer);
	}

	private String ask(String question) {
		System.out.println(question);
		return sc.next();
	}
}
