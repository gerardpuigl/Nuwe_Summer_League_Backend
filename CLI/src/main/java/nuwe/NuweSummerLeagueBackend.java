package nuwe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nuwe.infraestructure.cli.CommandsController;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@SpringBootApplication
public class NuweSummerLeagueBackend implements CommandLineRunner {

	public static void main(String[] args) {
		System.out.println("Processing...");
		SpringApplication.run(NuweSummerLeagueBackend.class, args);
	}

	@Autowired
    private IFactory factory;
	
	@Autowired
	private CommandsController commandsController;
	
	@Override
	public void run(String... args) {
		CommandLine commandLine = new CommandLine(commandsController, factory);
		commandLine.execute(args);
	}
	
	
}
