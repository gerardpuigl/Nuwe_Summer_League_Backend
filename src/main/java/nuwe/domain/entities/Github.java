package nuwe.domain.entities;

public class Github {

	private String username;

	private String url;

	private int repository_count;

	public Github() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getRepository_count() {
		return repository_count;
	}

	public void setRepository_count(int repository_count) {
		this.repository_count = repository_count;
	}

}
