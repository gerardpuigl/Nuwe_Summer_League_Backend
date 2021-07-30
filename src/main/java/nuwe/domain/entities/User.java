package nuwe.domain.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class User {
	
	@Id
	private String id;
	
	@NotBlank(message = "Name is mandatory.")
	private String name;
	
	@NotBlank(message = "Username is mandatory.")
	private String username;
	
	@Email(message="Email no valid.")
	@NotBlank
	private String email;
	
	@NotBlank(message = "Password is mandatory.")
	private String password;
	
	private Github github;

	public User() {
	}
	
	public User(String id, String name, String username, String email,String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password =  password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Github getGithub() {
		return github;
	}

	public void setGithub(Github github) {
		this.github = github;
	}
}
