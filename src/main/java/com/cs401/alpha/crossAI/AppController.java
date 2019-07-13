package com.cs401.alpha.crossAI;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

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
		Exercise exe = new Exercise(exercise, exercisedesc);
		System.out.println(exe.getExcercise());
		System.out.println(exe.getExcercisedesc());

		excerciseRepository.save(exe);

		uid = String.valueOf(exe.getIdexcercise());

		mv.addObject("uid", uid);
		mv.setViewName("exerciseAddedSucess");
		return mv;
	}

	@RequestMapping("/startCheckIn")
	public String startCheckIn() {

		return "startCheckIn";

	}

	@RequestMapping("/stopCheckIn") // this should generate the json file with user ids, exercises and other details
	public String stopCheckIn(Model model) throws FileNotFoundException {

		System.out.println("inside stop chekin");

		JSONObject joo = new JSONObject();
		joo = generateJson();

		System.out.println(joo);

		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(joo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		String dbStoredStatus = storeJsoninDatbase(joo); // the json that is created needs to loaded in database. this
															// call is for that purpose
		// System.out.println(jsonString);

		model.addAttribute("jsonexer", jsonString);
		return "stopCheckIn";

	}

	// @RequestMapping("/storeJsoninDatbase") // class complete, store json in
	// database
	public String storeJsoninDatbase(JSONObject joo) {
		// have to store json file in databse
		// have to extract user names and exericse dates, etx and store in db.

		return "success";
	}

	@RequestMapping("/generateJson") // checkin complete, generate json
	public JSONObject generateJson() throws FileNotFoundException {
		System.out.println("inside generateJson");

		Exercise exercise1 = new Exercise("pushup", "chest");
		Exercise exercise2 = new Exercise("pullup", "back");
		Exercise exercise3 = new Exercise("jumping jack", "cardio");

		ArrayList<Exercise> arraylist1 = new ArrayList<Exercise>();

		arraylist1.add(exercise1);
		arraylist1.add(exercise2);

		ArrayList<Exercise> arraylist2 = new ArrayList<Exercise>();
		arraylist2.add(exercise1);
		arraylist2.add(exercise2);
		arraylist2.add(exercise3);

		ArrayList<Exercise> arraylist3 = new ArrayList<Exercise>();
		arraylist3.add(exercise3);

		Types type1 = new Types(5, arraylist1);
		Types type2 = new Types(5, arraylist2);
		Types type3 = new Types(5, arraylist3);

		ExerciseTypes exerciseTypes1 = new ExerciseTypes("warmup", type1);
		ExerciseTypes exerciseTypes2 = new ExerciseTypes("Tabata", type2);
		ExerciseTypes exerciseTypes3 = new ExerciseTypes("cooldown", type3);

		ArrayList<ExerciseTypes> ET = new ArrayList<ExerciseTypes>();
		ET.add(exerciseTypes1);
		ET.add(exerciseTypes2);
		ET.add(exerciseTypes3);

		ArrayList<String> uids = new ArrayList<String>();
		uids.add("user1");
		uids.add("user2");
		uids.add("user3");

		ExerciseSession exerciseSession = new ExerciseSession(1, "july 11 2019", "16:00", "xfit", uids, ET);

		System.out.println(exerciseSession.getExercisetypes().size());

		JSONObject jo = new JSONObject();
		jo.put("id", exerciseSession.getId());
		jo.put("date", exerciseSession.getDate());
		jo.put("time", exerciseSession.getTime());
		jo.put("name", exerciseSession.getName());
		jo.put("userids", exerciseSession.getUserids());

		JSONArray joexternal = new JSONArray();

		for (ExerciseTypes et : exerciseSession.getExercisetypes()) {

			JSONObject jointernal = new JSONObject();

			System.out.println(et.getName() + et.getTypes());

			jointernal.put("name", et.getName());
			jointernal.put("duration", et.getTypes().getDuration());

			ArrayList<String> exercs = new ArrayList<String>();

			for (Exercise e : et.getTypes().getExercises()) {

				JSONObject jointernalinternal = new JSONObject();
				exercs.add(e.getExcercise());
			}

			jointernal.put("excercises", exercs);
			joexternal.add(jointernal);

		}
		jo.put("exercisetypes", joexternal);

		PrintWriter pw = new PrintWriter("ExerciseClass.json");
		pw.write(jo.toJSONString());

		pw.flush();
		pw.close();

		return jo;
		// return "generatedJsonFile";

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

	/**
	 * This end point is called from login page
	 * 
	 * @return registration page
	 */
	@GetMapping(path = "/registration") // calls registration form that has form action newuser
	public String registerUser() {
		return "registration";
	}

	/**
	 * This end point is called from registration
	 * 
	 * @return userAddedSucess page
	 */
	@PostMapping(path = "/newuser") // is called from registration
	public @ResponseBody ModelAndView createUser(@Valid User user) {

		ModelAndView mv = new ModelAndView();

		if (user.getAge() < 13) {
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

	@GetMapping(path = "/adminhome")
	public String adminhome(String uid) {
		System.out.println("inside admin home");
		return "adminHome";
	}

	@GetMapping(path = "/nonadminhome")
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

	@RequestMapping("/getUserDetails")
	public ModelAndView getUserDetails(@RequestParam String uid) {
		ModelAndView mv = new ModelAndView();

		System.out.println(uid);
		Optional<User> us = userRepository.findById(uid);

		System.out.println("showing user");
		System.out.println(us.toString());

		mv.addObject("userid", us.get().getUserId());
		mv.addObject("upassword", us.get().getPassword());
		mv.addObject("firstName", us.get().getFirstName());
		mv.addObject("lastName", us.get().getLastName());
		mv.addObject("email", us.get().getEmail());
		mv.addObject("phone", us.get().getPhone());
		mv.addObject("gender", us.get().getGender());
		mv.addObject("age", us.get().getAge());
		mv.addObject("height", us.get().getHeight());

		// mv.addObject(user);
		mv.setViewName("showUserDetails");
		return mv;
	}

	@GetMapping(path = "/allexcercises")
	public @ResponseBody Iterable<Exercise> getAllExercise() {
		return excerciseRepository.findAll();
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
