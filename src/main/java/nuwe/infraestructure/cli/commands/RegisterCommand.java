package nuwe.infraestructure.cli.commands;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;

@Component
@Command(name = "register" , mixinStandardHelpOptions = true, description = "Registrar un nuevo usuario")
public class RegisterCommand implements Runnable{

	@Override
	public void run() {
		System.out.println("Registrar un nuevo usuario...etc");
	}

}
