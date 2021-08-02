package timer;

import java.awt.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

		LocalDateTime taskTime = LocalDateTime.parse(alarmDate + "T" + alarmTime);
		Date taskTimeAsDate = Date.from(taskTime.atZone(ZoneId.systemDefault()).toInstant());

		Timer timer = new Timer();
		timer.schedule(setAlarm(message), taskTimeAsDate);
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
