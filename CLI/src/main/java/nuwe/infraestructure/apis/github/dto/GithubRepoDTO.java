package nuwe.infraestructure.apis.github.dto;

public class GithubRepoDTO {
	
	private String name;

	private String stack;

	private String github_url;

	private String url;


	public GithubRepoDTO() {

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
	
	//convert from api to our field
	public void setLanguage(String language) {
		this.stack = language;
	}

	public String getGithub_url() {
		return github_url;
	}

	public void setHtml_url(String github_url) {
		this.github_url = github_url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setDeployments_url(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "GithubRepoDTO [ name=" + name + ", stack=" + stack
				+ ", github_url=" + github_url + ", url=" + url + "]";
	}
}
