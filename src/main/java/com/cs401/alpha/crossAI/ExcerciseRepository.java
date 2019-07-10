package com.cs401.alpha.crossAI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ExcerciseRepository extends JpaRepository<exercise, Integer> {
	
	//INSERT INTO `alphadb`.`exercise` (`exercise`, `exercisedesc`) VALUES ('yyii', 'hiho');

	

}
