package nuwe.application.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class TimerService {
	
	public void setAlarm(String alarmDate, String alarmTime, String message) throws IOException {	
		ProcessBuilder timer = new ProcessBuilder("java","-jar", "Alarm.jar", alarmTime, alarmDate, message);
		timer.start();
	}

}
