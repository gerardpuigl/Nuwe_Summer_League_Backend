package nuwe.infraestructure.connexion;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientBuilder {

	// Singleton
	private static WebClient connexion;

	private WebClientBuilder() {
	}

	public static  WebClient getConnexion() {
		if (connexion == null) {
			connexion = configureWebClient();
		}
		return connexion;
	}

	private static WebClient configureWebClient() {
		return WebClient.builder()
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.baseUrl("http://localhost:8045")
				.build();
	};

}
