package nuwe;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nuwe.infraestructure.cli.CommandsController;
import nuwe.infraestructure.cli.Exception.ExceptionHandler;
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

	private CommandsController commandsController = new CommandsController();

	@Override
	public void run(String... args) {
		CommandLine commandLine = new CommandLine(commandsController, factory)
				.setExecutionExceptionHandler(new ExceptionHandler());
		commandLine.execute(args);
	}

}

/*
 * public class NuweSummerLeagueBackend {
 * 
 * public static void main(String[] args) {
 * Logger.getLogger("io.netty").setLevel(Level.OFF);
 * 
 * int exitCode = new CommandLine( new CommandsController())
 * .setExecutionExceptionHandler(new ExceptionHandler()) .execute(args);
 * System.exit(exitCode); } }
 */
