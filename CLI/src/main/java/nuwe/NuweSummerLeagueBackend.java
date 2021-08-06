package nuwe;

import nuwe.infraestructure.cli.CommandsController;
import picocli.CommandLine;

public class NuweSummerLeagueBackend {

    public static void main(String[] args) {
    	int exitCode = new CommandLine( new CommandsController()).execute(args);
    	System.exit(exitCode); 
    }	
}
