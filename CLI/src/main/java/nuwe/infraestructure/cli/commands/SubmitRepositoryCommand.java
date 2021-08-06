package nuwe.infraestructure.cli.commands;

import java.util.Scanner;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "submit_repository" , mixinStandardHelpOptions = true, description = "Submit Github Repository [more info with \"submit_repository -h\"]\"")
public class SubmitRepositoryCommand implements Runnable{

	@Option(names = {"-u", "username"}, required = false, description = "Enter username on execution" )
	private String username;
	
	@Option(names = { "-p", "password" }, required = false, description = "Enter password on execution")
	private String password;
	
	@Option(names = {"-url", "url"}, required = false, description = "Enter url github repository on execution" )
	private String urlGithubRepository;
	
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void run() {
		System.out.println("Selected Submit Repository to your user.");

		if (username == null) username = ask("username:");
		if (password == null) password = ask("password");

		try {
//			String answer = userService.login(username, password);			
//			System.out.println(answer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		if (urlGithubRepository == null) urlGithubRepository = ask("Url github repository:");
		
		try {
//			System.out.println(githubApiService.addProject(username,urlGithubRepository).toString());
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
