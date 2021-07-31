package nuwe.application.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import nuwe.application.exceptions.AlreadyExistsException;
import nuwe.domain.entities.Project;
import nuwe.domain.entities.User;
import nuwe.domain.repository.IProjectRepository;
import nuwe.domain.repository.IUserRepository;
import nuwe.infraestructure.apis.github.GithubApi;
import nuwe.infraestructure.apis.github.dto.GithubDTO;
import nuwe.infraestructure.apis.github.dto.GithubRepoDTO;


@Service
public class GithubApiService {
	
	@Autowired
	GithubApi githubApi;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IProjectRepository projectRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public GithubRepoDTO addProject(String username, String url) throws NotFoundException, AlreadyExistsException {
		
		//get Dto from api Repository and map to our entity
		GithubRepoDTO githubRepoDTO = githubApi.getGithubRepository(url);
		Project project = mapper.map(githubRepoDTO, Project.class);

		//get user that add this repository, set userId to project & increase in one the repository_count
		User user = userRepository.findByUsername(username).get();
		project.setUserId(user.getId());
		
		//check if already in the database and save it
		checkProjectExist(project.getGithub_url(),project.getUserId());
		projectRepository.save(project);
		
		//Increse repo count in one and update user
		user.getGithub().sum1toRepository_count();
		userRepository.save(user);

		return githubRepoDTO;
	}
	
	public String addGithubInformation(String username, String githubUser) throws NotFoundException {
		//get user to add the information
		User user = userRepository.findByUsername(username).get();
		
		GithubDTO githubDTO = githubApi.getGithubCredentials(githubUser);
		
		user.getGithub().setUsername(githubUser);
		user.getGithub().setUrl(githubDTO.getUrl());
		
		userRepository.save(user);
		return "Github credentails added to your user.";
	}

	
	private void checkProjectExist(String url,String userId) throws AlreadyExistsException {
		if (projectRepository.existsByGithub_urlAndUserId(url,userId))
			throw new AlreadyExistsException("Project already in your list.");
	}

}
