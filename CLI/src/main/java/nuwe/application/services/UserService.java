package nuwe.application.services;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import nuwe.infraestructure.connexion.WebClientBuilder;
import nuwe.infraestructure.dto.UserDTO;
import reactor.core.publisher.Mono;

public class UserService {

	private WebClient connexion  = WebClientBuilder.getConnexion();
	
	public String newUser( UserDTO user) {

		String answer =	connexion.post().uri("/user/register")
		.accept(MediaType.APPLICATION_JSON)
		.body(user, UserDTO.class)
		.retrieve()
		.bodyToMono(String.class).block();
		return answer;
		
	}

	public String login(UserDTO user) {
		
		String answer =	connexion.post().uri("/user/login")
		.accept(MediaType.APPLICATION_JSON)
		.body(Mono.just(user), UserDTO.class)
		.retrieve()
		.bodyToMono(String.class)
		.block();
		
		return answer;
	}
}
