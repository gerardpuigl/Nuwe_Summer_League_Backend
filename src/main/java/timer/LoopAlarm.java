package timer;

import java.awt.Component;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class LoopAlarm {

	public static void main(String[] args) {
		long period = Long.parseLong(args[0]);
		String message = "Coffee time!";

		// options
		if (args.length >= 2)
			message = args[1];

		Timer timer = new Timer();
		
		long periodMilliseconds = TimeUnit.MILLISECONDS.convert(period, TimeUnit.MINUTES);
		timer.schedule(setAlarm(message),periodMilliseconds,periodMilliseconds);
	}

	private static TimerTask setAlarm(String message) {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				Component Jframe = null;
				String[] options = { "Cancel", "Repead" };
				int option = JOptionPane.showOptionDialog(Jframe, message, "Alarm Rining", JOptionPane.PLAIN_MESSAGE,
						JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				System.out.println(option);
				if (option == 0) System.exit(0);
			}
		};
		return timerTask;
	}
}
