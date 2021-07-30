package nuwe.infraestructure.cli.commands;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nuwe.application.services.UserService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Component
@Command(name = "login", mixinStandardHelpOptions = true, description = "Login user with username and password. [more info with \"login -h\"]")
public class LoginCommand implements Runnable {

	private Scanner sc = new Scanner(System.in);

	@Option(names = { "-u", "username" }, required = false, description = "Enter username on execution")
	private String username;

	@Option(names = { "-p", "password" }, required = false, description = "Enter password on execution")
	private String password;

	@Autowired
	private UserService userService;

	@Override
	public void run() {
		System.out.println("Yo select to login with username & password.");

		if (username == null) username = ask("username");
		if (password == null) password = ask("password");

		try {
			String answer = userService.login(username, password);			
			System.out.println(answer);
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
