package com.cs401.alpha.crossAI;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs401.alpha.crossAI.User;
import com.cs401.alpha.crossAI.UserRepository;

@Controller
public class AppController {

	@Autowired
	private ExcerciseRepository excerciseRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	@RequestMapping("/test")
	@GetMapping("/test")
	public String test() {
		System.out.println("Welcome test");
		return "test";
	}

	/**
	 * 
	 * Web end point Aboutus for About us data
	 * 
	 * @return aboutus.jsp page
	 */
	@RequestMapping("/Aboutus")
	public String aboutus(Model model) {
		System.out.println("Welcome about us");
		AboutusBusinesslogic business = new AboutusBusinesslogic();
		List<Aboutus> listus = business.getAboutusList();
		model.addAttribute("aboutus", listus);
		return "aboutus";
	}

	/**
	 * 
	 * Rest end point AboutusRest for a GET call to get About us data
	 * 
	 * @return A list containing About us data
	 */

	@GetMapping("/AboutusRest")
	@ResponseBody
	public List<Aboutus> aboutusrest() {
		System.out.println(" Rest Get call about us");
		AboutusBusinesslogic business = new AboutusBusinesslogic();
		List<Aboutus> listus = business.getAboutusList();
		return listus;
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/oneuser")
	public @ResponseBody Optional<User> getOneUser() {
		return userRepository.findById("user1");
	}
	
	
	@GetMapping(path="/allexcercises")
	public @ResponseBody Iterable<exercise> getAllExercise() {
		return excerciseRepository.findAll();
	}

	
	
	/*@GetMapping("/user")
	@Bean
	public void index(UserRepository urep) {
		System.out.println("inside /user target");
		// return userRespository.findAllByUserID("user1");
		urep.findByuserId("user1");
	}*/

	/*
	 * @GetMapping("/user/{id}") public User show(@PathVariable String id) { // int
	 * blogId = Integer.parseInt(id); String userid = id; // return
	 * userRespository.findOne(userid); return userRespository.findByuserId(userid);
	 * // .findOne(userid);
	 * 
	 * }
	 */

}
