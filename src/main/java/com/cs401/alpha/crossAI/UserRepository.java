package com.cs401.alpha.crossAI;


import org.springframework.stereotype.Component;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

import com.cs401.alpha.crossAI.User;

@Repository
@Component
public interface UserRepository extends CrudRepository<User, String> {

	//User findByuserId(String userid);
	//User findAllByUserID(String userid);
	
	//List<User> findByuserId(String text, String textAgain);
	//List<User> findBy
	//List<User> findByuserId(String userid);

}
