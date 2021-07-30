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
		user.getGithub().sum1toRepository_count();
		
		//check if already in the database
		checkProjectExist(project.getGithub_url(),project.getUserId());
		
		//save both entities
		userRepository.save(user);
		projectRepository.save(project);
		
		return githubRepoDTO;
	}
	
	private void checkProjectExist(String url,String userId) throws AlreadyExistsException {
		if (projectRepository.existsByGithub_urlAndUserId(url,userId))
			throw new AlreadyExistsException("Project already in your list.");
	}

}
