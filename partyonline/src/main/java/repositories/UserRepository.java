package repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import domain.User;

public interface UserRepository extends CrudRepository<User, Long> {	
	@Query(value="SELECT ID, USERNAME, PASSWORD, ENABLED FROM USERS WHERE USERNAME = :username", nativeQuery = true)
	User findUser(@Param("username") String username);	
}
