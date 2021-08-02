package nuwe.application.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class TimerService {
	
	public void setAlarm(String username, String alarmDate, String alarmTime) throws IOException {	
		ProcessBuilder timer = new ProcessBuilder("java","-jar", "Alarm.jar", alarmTime, alarmDate, "Coffee time!");
		timer.start();
	}

}
