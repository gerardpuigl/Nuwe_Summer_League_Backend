package nuwe.infraestructure.cli.commands;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nuwe.application.services.TimerService;
import nuwe.application.services.UserService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Component
@Command(name = "rest_time" , mixinStandardHelpOptions = true, description = "Create an alarm [more info with \"submit_repository -h\"]\"")
public class RestTimeCommand implements Runnable{

	@Option(names = {"-u", "username"}, required = false, description = "Enter username on execution" )
	private String username;
	
	@Option(names = { "-p", "password" }, required = false, description = "Enter password on execution")
	private String password;
	
	@Option(names = {"-d","date"}, required = false, description = "Set Date for the alarm in format \"year-month-day\"")
	private String alarmDate;
	
	@Option(names = {"-t", "time"}, required = false, description = "Set time in format \"hour:minutes:seconds\"" )
	private String alarmTime;

	private Scanner sc = new Scanner(System.in);

	@Autowired
	private UserService userService;
	
	@Autowired
	private TimerService timerService;
	
	@Override
	public void run() {
		
		System.out.println("Selected Submit Repository to your user.");

		if (username == null) username = ask("username:");
		if (password == null) password = ask("password");

		try {
			String answer = userService.login(username, password);			
			System.out.println(answer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		if (alarmDate == null) alarmDate = ask("Date in format \"year-month-day\":");
		if (alarmTime == null) alarmTime = ask("Time in format \"hour:minutes:seconds\":");
		
		
		try {
			timerService.setAlarm(username, alarmDate, alarmTime);
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
