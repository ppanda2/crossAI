package com.cs401.alpha.crossAI;

import org.springframework.stereotype.Component;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.cs401.alpha.crossAI.User;

@Repository
@Component
public interface UserRepository extends CrudRepository<User, String> {

	// User findByuserId(String userid);
	// User findAllByUserID(String userid);
	// List<User> findByuserId(String text, String textAgain);
	// List<User> findByuserId(String userid);

}
