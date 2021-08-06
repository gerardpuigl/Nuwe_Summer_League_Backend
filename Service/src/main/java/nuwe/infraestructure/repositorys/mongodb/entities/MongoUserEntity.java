package nuwe.infraestructure.repositorys.mongodb.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import nuwe.domain.entities.Github;


@Document(collection = "user")
public class MongoUserEntity {
	
	@Id
	private String id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Indexed(unique=true)
	private String username;
	
	@NotBlank
	@Email(message="Email no valid.")
	@Indexed(unique=true)
	private String email;
	
	@NotBlank
	private String password;
	
	private Github github;
	
	public MongoUserEntity() {
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

	@JsonIgnore
	public boolean isNew() {
		return (getId() == null);
	}
}
