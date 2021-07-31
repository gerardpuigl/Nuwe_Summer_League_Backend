package nuwe.infraestructure.repositorys.mongodb;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import nuwe.infraestructure.repositorys.mongodb.entities.MongoProjectEntity;

@Repository
public interface IMongoProjectRepository extends MongoRepository<MongoProjectEntity, String> {

	public Optional<MongoProjectEntity> findByUserId(String userId);

	public boolean existsByGithubUrl(String github_url);

	public boolean existsByGithubUrlAndUserId(String github_url, String userId);

}
