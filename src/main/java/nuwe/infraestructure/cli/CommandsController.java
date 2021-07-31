package nuwe.infraestructure.cli;

import org.springframework.stereotype.Component;

import nuwe.infraestructure.cli.commands.GithubConfigCommand;
import nuwe.infraestructure.cli.commands.LoginCommand;
import nuwe.infraestructure.cli.commands.RegisterCommand;
import nuwe.infraestructure.cli.commands.SubmitRepositoryCommand;
import picocli.CommandLine.Command;

@Component
@Command(description = "Welcome to this CLI app done by Gerard Puig done for the Summer League done by Nuwe.",
		mixinStandardHelpOptions = true , subcommands = {
				LoginCommand.class, RegisterCommand.class, SubmitRepositoryCommand.class, GithubConfigCommand.class})
public class CommandsController implements Runnable{
	
    public void run() {
            System.out.println("Add \"-h\" o \"--help\" to list the available commands");
    }
}
