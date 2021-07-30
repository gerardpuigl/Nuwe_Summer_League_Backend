package nuwe.application.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import nuwe.application.exceptions.AlreadyExistsException;
import nuwe.domain.entities.User;
import nuwe.domain.repository.IUserRepository;

@Service
public class UserService {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

//	@Autowired
//	ApiMailboxlayer apiMailboxlayer;

	@Autowired
	ModelMapper modelMapper;

	public boolean login(String username, String password) {
		User user = userRepository.findByUsername(username).get();
		
		if(passwordEncoder.matches(password, user.getPassword())) {
			return true;
		}
		return false;
	}
	

	private void checkUsername(String username) throws AlreadyExistsException {
		if (userRepository.existsByUsername(username))
			throw new AlreadyExistsException("Username already in use.");
	}

}
