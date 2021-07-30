package nuwe.application.services;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import nuwe.application.exceptions.AlreadyExistsException;
import nuwe.application.exceptions.WrongPasswordException;
import nuwe.domain.entities.User;
import nuwe.domain.repository.IUserRepository;

@Service
@Validated
public class UserService {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

//	@Autowired
//	ApiMailboxlayer apiMailboxlayer;

	@Autowired
	ModelMapper modelMapper;

	public boolean newUser(@Valid User user) throws AlreadyExistsException {

		// Check if the username is used.
		checkUsername(user.getUsername());

		// encode Password
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userRepository.save(user);
		return true;
	}
	
	public String login(String username, String password) throws NoSuchElementException, WrongPasswordException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(()->new NoSuchElementException("The user doesn't exist"));
		
		if(passwordEncoder.matches(password, user.getPassword())) throw new WrongPasswordException("Wrong password.");
		
		return "Login successful.\nWelcome " + username + "!";
	}
		
	private void checkUsername(String username) throws AlreadyExistsException {
		if (userRepository.existsByUsername(username))
			throw new AlreadyExistsException("Username already in use.");
	}

}
