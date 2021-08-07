package nuwe.infraestructure.cli.commands;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nuwe.application.services.TimerService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Component
@Command(name = "break_time", mixinStandardHelpOptions = true, description = "Create a repeteable warning each XX minutes [more info with \"submit_repository -h\"]\"")
public class BreakTimeCommand implements Runnable {

	@Option(names = { "-t", "time" }, required = false, description = "Set time loop in minutes")
	private int minutes = 0;

	@Option(names = { "-m", "message" }, required = false, description = "Set message for the alarm [Optional]")
	private String message = "Coffee Time!";

	private Scanner sc = new Scanner(System.in);

	@Autowired
	private TimerService timerService;

	@Override
	public void run() {

		System.out.println("Selected create a repeteable warning.");

		if (minutes == 0) minutes = ask("Set time loop in minutes:");

		try {
			timerService.setLoopAlarm(String.valueOf(minutes), message);
			if (minutes == 1) {
				System.out.println("Alarm set for a period of " + minutes + " minute");
			} else {
				System.out.println("Alarm set for a period of " + minutes + " minutes.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	private int ask(String question) {
		System.out.println(question);
		return sc.nextInt();
	}

}
