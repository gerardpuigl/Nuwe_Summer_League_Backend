package timer;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class DailyAlarm {

	public static void main(String[] args) throws ParseException {
		Date alarmTime = new SimpleDateFormat("dd-mm-yyyy hh:mm").parse(LocalDate.now().toString() + " " + args[0]);
		String message = "Wake Up! Wake Up!";

		// options
		if (args.length >= 2) message = args[1];

		Timer timer = new Timer();
		timer.schedule(setAlarm(message), alarmTime, TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
	}

	private static TimerTask setAlarm(String message) {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				Component Jframe = null;
				JOptionPane.showMessageDialog(Jframe, message, "Alarm Ringing", JOptionPane.PLAIN_MESSAGE);
			}
		};
		return timerTask;
	}
}
