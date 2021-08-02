package timer;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class DateAlarm {

	public static void main(String[] args) {
		String alarmTime = args[0];
		String alarmDate = LocalDate.now().toString();
		String message = "Wake Up! Wake Up!";

		// options
		if (args.length >= 2) alarmDate = args[1];
		if (args.length >= 3) message = args[2];

		Date taskTime = null;
		
		try {
			taskTime = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(alarmDate + " " + alarmTime);
			System.out.println(taskTime.toString());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
		Timer timer = new Timer();
		timer.schedule(setAlarm(message), taskTime);
	}

	private static TimerTask setAlarm(String message) {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				Component Jframe = null;
				JOptionPane.showMessageDialog(Jframe, message, "Alarm Ringing", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		};
		return timerTask;
	}
}
