package nuwe.application.services;

import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import nuwe.domain.entities.User;
import nuwe.domain.repository.IUserRepository;
import nuwe.infraestructure.apis.ApiGithub;
import nuwe.infraestructure.dto.GithubDTO;


@Service
public class GitProfileService {
/*
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ApiGithub apiGithub;
	
	//To map entity to DTO.
	@Autowired
	ModelMapper modelMapper;
	
	public GithubDTO getGitHubProfile(String id) throws NotFoundException {
		User user = getUserById(id);
		GithubDTO githubDTO = apiGithub.getGithubCredentials(user.getGithubUserId());
		return githubDTO;
	}

	
	public GithubDTO postGitHubProfile(String username, String id) throws NotFoundException {
		User user = getUserById(id);
		user.setGithubUserId(username);
		userRepository.save(user);
		GithubDTO githubDTO = apiGithub.getGithubCredentials(user.getGithubUserId());
		return githubDTO;
	}

	private User getUserById(String id) {
		if(!userRepository.existsById(id)) throw new NoSuchElementException();
		User user = userRepository.findById(id).
				orElseThrow(() -> new NoSuchElementException("No user with this id: " + id));
		return user;
	}
*/
	
}
