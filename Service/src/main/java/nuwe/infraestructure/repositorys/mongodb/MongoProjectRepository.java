package nuwe.infraestructure.repositorys.mongodb;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import nuwe.domain.entities.Project;
import nuwe.domain.repository.IProjectRepository;
import nuwe.infraestructure.repositorys.mongodb.entities.MongoProjectEntity;

@Component
@Primary
public class MongoProjectRepository implements IProjectRepository {

	@Autowired
	private final IMongoProjectRepository projectRepository;

	// To map entity to DTO.
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public MongoProjectRepository(final IMongoProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	@Override
	public Optional<Project> findById(String id) {
		MongoProjectEntity projectMongo = projectRepository.findById(id).get();
		Project project = null;
		if (projectMongo != null) project = modelMapper.map(projectMongo, Project.class);
		return Optional.ofNullable(project);
	}

	@Override
	public Optional<Project> findByUserId(String userId) {
		MongoProjectEntity projectMongo = projectRepository.findByUserId(userId).get();
		Project project = null;
		if (projectMongo != null) project = modelMapper.map(projectMongo, Project.class);
		return Optional.ofNullable(project);
	}

	@Override
	public boolean existsByGithub_url(String github_url) {
		return projectRepository.existsByGithubUrl(github_url);
	}
	
	@Override
	public boolean existsByGithub_urlAndUserId(String github_url,String userId) {
		return projectRepository.existsByGithubUrlAndUserId(github_url,userId);
	}

	@Override
	public boolean existsById(String id) {
		return projectRepository.existsById(id);
	}

	@Override
	public Project save(Project project) {
		MongoProjectEntity projectMongo = modelMapper.map(project, MongoProjectEntity.class);
		projectMongo = projectRepository.save(projectMongo);
		return modelMapper.map(projectMongo,Project.class);
	}

	@Override
	public void delete(Project project) {
		MongoProjectEntity projectMongo = modelMapper.map(project, MongoProjectEntity.class);
		projectRepository.delete(projectMongo);
	}
}
