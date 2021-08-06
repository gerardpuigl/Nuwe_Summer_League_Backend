package nuwe.infraestructure.repositorys.mongodb.entities;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "project")
public class MongoProjectEntity {

	@Id
	private String id;
	
	@NotBlank
	private String userId;
	
	@NotBlank
	private String name;

	@NotBlank
	private String stack;

	@NotBlank
	private String githubUrl;

	@NotBlank
	private String url;
	
	public MongoProjectEntity() {
		
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public String getGithub_url() {
		return githubUrl;
	}

	public void setGithub_url(String github_url) {
		this.githubUrl = github_url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
