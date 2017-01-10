package br.com.rockbox.repositoryInterfaces;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.rockbox.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("{'name' : ?0}")
	public Iterable<User> searchByUsername(String username);
	
	
}
