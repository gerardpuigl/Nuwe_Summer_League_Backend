package nuwe.domain.repository;

import java.util.Optional;

import nuwe.domain.entities.User;

public interface IUserRepository {
		
	public User findByEmail(String email);

	public Optional<User> findByUsername(String username);

	public boolean existsByUsername(String username);

	public Optional<User> findById(String id);

	public void delete(User user);

	public User save(User user);

	public boolean existsById(String id);

}
