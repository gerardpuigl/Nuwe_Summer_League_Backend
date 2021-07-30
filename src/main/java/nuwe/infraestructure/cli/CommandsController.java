package nuwe.infraestructure.cli;

import org.springframework.stereotype.Component;

import nuwe.infraestructure.cli.commands.LoginCommand;
import nuwe.infraestructure.cli.commands.RegisterCommand;
import nuwe.infraestructure.cli.commands.SubmitRepositoryCommand;
import picocli.CommandLine.Command;

@Component
@Command(description = "Welcome to this CLI app done by Gerard Puig done for the Summer League done by Nuwe.",
		mixinStandardHelpOptions = true , subcommands = {LoginCommand.class , RegisterCommand.class, SubmitRepositoryCommand.class})
public class CommandsController implements Runnable{
	
    public void run() {
            System.out.println("Debes introducir \"-h\" o \"--help\" despues del nombre de la aplicación para ver los comandos disponibles");
    }
}
