package nuwe.infraestructure.cli.Exception;

import org.springframework.web.reactive.function.client.WebClientRequestException;

import picocli.CommandLine;
import picocli.CommandLine.IExecutionExceptionHandler;
import picocli.CommandLine.ParseResult;

public class ExceptionHandler implements IExecutionExceptionHandler {

	@Override
	public int handleExecutionException(Exception ex, CommandLine commandLine, ParseResult parseResult)
			throws Exception {
		
		if(ex instanceof WebClientRequestException ) {
			System.out.println("Service down. Start the Nuwe CLI service using the command \"nuwe start\"");
		}else {

			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
System.out.println("hello there");				
		}
		return 0;
	}

}
