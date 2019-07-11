package com.cs401.alpha.crossAI;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/login")
	@GetMapping("/login")
	public String Login() {
		System.out.println("Welcome Login");
		return "login";
	}

	@RequestMapping("home")
	public ModelAndView home(@RequestParam(value = "name", required = false) String myName,
			@RequestParam(value = "age", required = false) Integer myAge) {

		ModelAndView mv = new ModelAndView();
		if (myName.equals(null) || myName.equals("")) {
			myName = "Tester";
		}
		mv.addObject("name", myName);
		if (myAge < 0) {
			System.out.println("Age can't be a -ve value so seteting it to 0");
			myAge = 0;
		} else if (myAge > 0) {
			myAge = myAge;

		} else {
			myAge = -1;
		}

		mv.addObject("age", myAge);
		mv.setViewName("home");
		return mv;

	}

	@RequestMapping("/addExercise")
	public String addanExercise() {
		return "addExerciseView";
	}

	@RequestMapping("/addexercise")
	@ResponseBody
	public ModelAndView addexercise(String exercise, String exercisedesc) {

		ModelAndView mv = new ModelAndView();
		System.out.println("inside addexercise from form view");
		String uid = "";
		exercise exe = new exercise(exercise, exercisedesc);
		System.out.println(exe.getExcercise());
		System.out.println(exe.getExcercisedesc());

		excerciseRepository.save(exe);

		uid = String.valueOf(exe.getIdexcercise());

		mv.addObject("uid", uid);
		mv.setViewName("exerciseAddedSucess");
		return mv;
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
		return userRepository.findAll();
	}

	@PostMapping(path = "/newuserrest")
	public ResponseEntity<Object> createUserrest(@Valid @RequestBody User user) {

		System.out.println("inside new user creation");
		User u = userRepository.save(user);

		System.out.println("new user creaetd");
		String createdUid = u.getUserId();
		System.out.println(createdUid);

		Optional<User> us = getUserAfterCreate(createdUid);
		System.out.println(us);
		System.out.println(us.get().getFirstName());

		return new ResponseEntity<>(us, HttpStatus.CREATED);
	}

	@PostMapping(path = "/newuser")
	public @ResponseBody ModelAndView createUser(@Valid User user) {

		ModelAndView mv = new ModelAndView();
		
		if (user.getAge() <13)
		{
			System.out.println("user too young");
		}
		
		
		
		
		User u = userRepository.save(user);

		String createdUid = u.getUserId();
		System.out.println(createdUid);

		Optional<User> us = getUserAfterCreate(createdUid);
		System.out.println(us);
		System.out.println(us.get().getFirstName());

		// return new ResponseEntity<>(us, HttpStatus.CREATED);

		mv.addObject("userid", us.get().getUserId());
		mv.addObject("upassword", us.get().getPassword());
		mv.addObject("firstName", us.get().getFirstName());
		mv.addObject("lastName", us.get().getLastName());
		mv.addObject("email", us.get().getEmail());
		mv.addObject("phone", us.get().getPhone());
		mv.addObject("gender", us.get().getGender());
		mv.addObject("age", us.get().getAge());
		mv.addObject("height", us.get().getHeight());

		mv.setViewName("userAddedSucess");
		return mv;
	}

	
	@GetMapping (path = "/adminhome")
	public String adminhome(String uid) {
		System.out.println("inside admin home");
		return "adminHome";
	}
	
	@GetMapping (path = "/nonadminhome")
	public String nonadminhome(String uid) {
		System.out.println("inside non admin home");
		return "nonadminHome";
	}
	
//	@GetMapping
	public @ResponseBody Optional<User> getUserAfterCreate(String uid) {
		System.out.println("inside getUserAfterCreate");
		return userRepository.findById(uid);
	}

	@GetMapping(path = "/oneuser")
	public @ResponseBody Optional<User> getOneUser() {
		return userRepository.findById("user1");
	}

	@GetMapping(path = "/allexcercises")
	public @ResponseBody Iterable<exercise> getAllExercise() {
		return excerciseRepository.findAll();
	}

	@GetMapping(path = "/registration")
	public String registerUser() {
		return "registration";

	}

	/*
	 * @GetMapping("/user")
	 * 
	 * @Bean public void index(UserRepository urep) {
	 * System.out.println("inside /user target"); // return
	 * userRespository.findAllByUserID("user1"); urep.findByuserId("user1"); }
	 */

	/*
	 * @GetMapping("/user/{id}") public User show(@PathVariable String id) { // int
	 * blogId = Integer.parseInt(id); String userid = id; // return
	 * userRespository.findOne(userid); return userRespository.findByuserId(userid);
	 * // .findOne(userid);
	 * 
	 * }
	 */

}
