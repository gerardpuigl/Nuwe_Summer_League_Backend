package nuwe.domain.entities;

import org.springframework.data.annotation.Id;

public class Project {

	@Id
	private String id;
	
	private String userId;
	
	private String name;

	private String stack;

	private String github_url;

	private String url;

	public String getId() {
		return id;
	}
	
	public Project() {
		
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
		return github_url;
	}

	public void setGithub_url(String github_url) {
		this.github_url = github_url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
