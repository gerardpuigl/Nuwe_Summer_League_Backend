package nuwe.infraestructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nuwe.application.services.GithubApiService;
import nuwe.application.services.UserService;


@RestController
@RequestMapping("/user/{id}")
public class GitProfileController {

	//TODO submit_repository with url
	//TODO github_config

	@Autowired
	private GithubApiService githubService;

	@GetMapping("/githubconfig/{username}/{githubuser}")
	public String addGithubCredentials(@PathVariable("username") String username, @PathVariable("githubuser") String githubUser) throws NotFoundException {
		String answer = githubService.addGithubInformation(username, githubUser);
		return answer;		
	}
	
	@GetMapping("/submitrepository/{username}/{urlrepository}")
	public String addRepository(@PathVariable("username") String username, @PathVariable("urlrepository") String githubUser) throws NotFoundException {
		String answer = githubService.addGithubInformation(username, githubUser);
		return answer;		
	}
	
}
