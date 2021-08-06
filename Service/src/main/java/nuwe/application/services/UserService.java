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
import nuwe.infraestructure.dto.UserDTO;

@Service
@Validated
public class UserService {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper modelMapper;
	
	public String newUser(@Valid UserDTO userDTO) throws AlreadyExistsException {

		// Check if the username is used.
		checkUsername(userDTO.getUsername());

		// encode Password
		userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

		User user = modelMapper.map(userDTO, User.class);
		
		userRepository.save(user);
		return "User registered correctly.";
	}

	public String login(String username, String password) throws NoSuchElementException, WrongPasswordException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new NoSuchElementException("The user doesn't exist"));

		if (!passwordEncoder.matches(password, user.getPassword()))
			throw new WrongPasswordException("Wrong password.");

		return "Login successful.\nWelcome " + username + "!";
	}

	private boolean checkUsername(String username) throws AlreadyExistsException {
		if (userRepository.existsByUsername(username))
			throw new AlreadyExistsException("Username already in use.");
		return true;
	}
}
