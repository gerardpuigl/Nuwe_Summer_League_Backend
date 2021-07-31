package nuwe.infraestructure.cli.commands;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nuwe.application.services.GithubApiService;
import nuwe.application.services.UserService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Component
@Command(name = "github_config" , mixinStandardHelpOptions = true, description = "Add github user & url [more info with \"github_config -h\"]\"")
public class GithubConfigCommand implements Runnable{

	@Option(names = {"-u", "username"}, required = false, description = "Enter username on execution" )
	private String username;
	
	@Option(names = { "-p", "password" }, required = false, description = "Enter password on execution")
	private String password;
	
	@Option(names = {"-gu", "github_user"}, required = false, description = "Enter github username on execution" )
	private String githubUser;
	
	private Scanner sc = new Scanner(System.in);

	@Autowired
	private UserService userService;

	@Autowired
	private GithubApiService githubService;
	
	@Override
	public void run() {
		System.out.println("Selected add github credentials to your user.");

		if (username == null) username = ask("username:");
		if (password == null) password = ask("password");

		try {
			String answer = userService.login(username, password);			
			System.out.println(answer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

		if (githubUser == null) githubUser = ask("Username on github");
		
		try {
			System.out.println(githubService.addGithubInformation(username, githubUser).toString());
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
