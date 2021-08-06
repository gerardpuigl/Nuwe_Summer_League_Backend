package nuwe.infraestructure.controllers;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nuwe.application.exceptions.AlreadyExistsException;
import nuwe.application.exceptions.WrongPasswordException;
import nuwe.application.services.TimerService;
import nuwe.application.services.UserService;
import nuwe.infraestructure.dto.UserDTO;

@RestController
//@RequestMapping("/user")
public class TimerController {

	//TODO set daily alarm advicing stop to work
	//TODO set break time in minutes

	@Autowired
	private TimerService timerService;
	
	@PostMapping("/restTime")
	public String setRestTime(@Valid @RequestBody UserDTO user) {
			//timerService.setAlarm(alarmDate, alarmTime, message);
		return "in progress";
	}

	@PostMapping("/breakTime")
	public String setBreakTime(@Valid @RequestBody UserDTO user) {

//		timerService.setLoopAlarm(String.valueOf(minutes), message);
		return "in progress";		
	}
}
