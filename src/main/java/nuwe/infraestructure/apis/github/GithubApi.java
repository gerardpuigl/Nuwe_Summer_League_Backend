package nuwe.infraestructure.apis.github;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import nuwe.infraestructure.apis.github.dto.GithubDTO;
import nuwe.infraestructure.apis.github.dto.GithubRepoDTO;

@Component
public class GithubApi {
	
    @Autowired
    WebClient webClient;
    
	public GithubDTO getGithubCredentials(String username) throws NotFoundException {
		GithubDTO githubDTO = webClient.get()
			.uri("https://api.github.com/users/" + username)
			.accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.bodyToMono(GithubDTO.class)
			.block();
		
		List<GithubRepoDTO> githubReposUrl = webClient.get()
				.uri(githubDTO.getRepos_url())
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(GithubRepoDTO.class)
				.buffer().blockLast();
		
		githubDTO.setRepositories(githubReposUrl);
		
		return githubDTO;
	}

	public GithubRepoDTO getGithubRepository(String url) throws NotFoundException {
		
		//cleaning url
		if(url.contains("github.com/")) {
			url = url.replace("https://github.com/", "");
			url = url.replace("github.com/", "");
		}
		
		GithubRepoDTO githubRepoDTO = webClient.get()
			.uri("https://api.github.com/repos/" + url)
			.accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.bodyToMono(GithubRepoDTO.class)
			.block();
		
		return githubRepoDTO;
	}
}
