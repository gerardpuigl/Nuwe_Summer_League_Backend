package nuwe.infraestructure.cli.commands;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nuwe.application.services.TimerService;
import nuwe.application.services.UserService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Component
@Command(name = "rest_time" , mixinStandardHelpOptions = true, description = "Create an alarm [more info with \"submit_repository -h\"]\"")
public class RestTimeCommand implements Runnable{

	@Option(names = {"-d","date"}, required = false, description = "Set Date for the alarm in format \"day-month-year\"")
	private String alarmDate;
	
	@Option(names = {"-t", "time"}, required = false, description = "Set time in format \"hour:minutes\"" )
	private String alarmTime;
	
	@Option(names = {"-m", "message"}, required = false, description = "Set message for the alarm \"hour:minutes\"" )
	private String message;

	private Scanner sc = new Scanner(System.in);

	@Autowired
	private TimerService timerService;
	
	@Override
	public void run() {
		
		System.out.println("Selected create an alarm.");
		
		if (alarmDate == null) alarmDate = ask("Date in format \"day-month-year\":");
		
		alarmDate = validateDateFormat(alarmDate);
		
		if (alarmTime == null) alarmTime = ask("Time in format 24 \"hour:minutes\" format:");
		
		alarmTime = validateTimeFormat(alarmTime);

		
		try {
			timerService.setAlarm(alarmDate, alarmTime, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	private String ask(String question) {
		System.out.println(question);
		return sc.next();
	}
	
	private String validateDateFormat(String alarmDate) {
		while (!GenericValidator.isDate(alarmDate, "dd-MM-yyyy",false)) {
			alarmDate = ask("Date wrong, the format should be \"day-month-year\":");
		};
		return alarmDate;
	}

	private String validateTimeFormat(String alarmTime) {
		Pattern timeValidator = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
		while (!timeValidator.matcher(alarmTime).find()) {
			alarmTime = ask("Time wrong, the format should be \"hour:minutes\":");
		};
		return alarmTime;
	}
}
