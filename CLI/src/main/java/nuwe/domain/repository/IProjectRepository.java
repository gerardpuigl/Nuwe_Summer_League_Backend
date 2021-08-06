package nuwe.domain.repository;

import java.util.Optional;

import nuwe.domain.entities.Project;

public interface IProjectRepository {

	public Optional<Project> findById(String id);

	public Optional<Project> findByUserId(String userId);

	public boolean existsByGithub_url(String github_url);

	public boolean existsByGithub_urlAndUserId(String url, String userId);

	public boolean existsById(String id);
	
	public Project save(Project project);

	public void delete(Project project);

}
