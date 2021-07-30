package nuwe.domain;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import nuwe.domain.entities.User;
import nuwe.domain.repository.IUserRepository;

@Component
public class InitialData {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void populate() {
		
		User user1 = new User("60c4b7968c71c14b521ed76a", "TestUser01", "User01", "TestUser01@nuwe.io", passwordEncoder.encode("hackathonMWC"));
		User user2 = new User("60c4b7968c71c14b521ed76b", "TestUser02", "User02", "TestUser02@nuwe.io", passwordEncoder.encode("hackathonMWC"));
		userRepository.save(user2);
		userRepository.save(user1);

	};
}
